package dao;

import model.Passager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassagerDAO {
    private final Connection connection;

    public PassagerDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter un passager à la base de données
    public void ajouterPassager(Passager passager) {
        // Vérifier que la connexion n'est pas nulle ou fermée
        if (connection == null) {
            System.err.println("Erreur : la connexion à la base de données est nulle.");
            return;
        }

        try {
            if (connection.isClosed()) {
                System.err.println("Erreur : la connexion à la base de données est fermée.");
                return;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification de la connexion : " + e.getMessage());
            return;
        }

        // Requête SQL d'insertion
        String sql = "INSERT INTO passagers (nom, email, passeport) VALUES (?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("Préparation de la requête pour l'insertion du passager...");
            
            // Paramétrer les valeurs du passager
            statement.setString(1, passager.getNom());
            statement.setString(2, passager.getEmail());
            statement.setString(3, passager.getPasseport());

            // Exécuter l'insertion
            int rowsAffected = statement.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);
    
            // Vérifier si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Passager inséré avec succès.");

                // Récupérer l'ID généré automatiquement
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGeneré = generatedKeys.getInt(1);
                        passager.setId(idGeneré);  // Affecter l'ID au passager
                        System.out.println("ID généré : " + idGeneré);
                    } else {
                        System.err.println("Aucun ID généré trouvé après l'insertion.");
                    }
                }
            } else {
                System.err.println("Aucune ligne n'a été insérée dans la base de données.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du passager : " + e.getMessage());
        }
    }

    // Méthode pour récupérer tous les passagers de la base de données
    public List<Passager> obtenirTousLesPassagers() {
        List<Passager> passagers = new ArrayList<>();
        String sql = "SELECT * FROM passagers";

        try {
            // Vérifier si la connexion est ouverte
            if (connection == null || connection.isClosed()) {
                System.err.println("Erreur : Connexion à la base de données fermée !");
                return passagers;
            }

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String email = resultSet.getString("email");
                    String passeport = resultSet.getString("passeport");

                    // Créer un nouvel objet Passager avec les données récupérées
                    Passager passager = new Passager(id, nom, email, passeport);
                    passagers.add(passager);
                }

            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des passagers : " + e.getMessage());
        }

        return passagers;
    }
}
