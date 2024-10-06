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
    public void ajouterPassager(Passager passager) throws SQLException {
        String sql = "INSERT INTO passagers (nom, email, passeport) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, passager.getNom());
            statement.setString(2, passager.getEmail());
            statement.setString(3, passager.getPasseport());
            statement.executeUpdate();
        }
    }

    // Nouvelle méthode pour récupérer tous les passagers
    public List<Passager> obtenirTousLesPassagers() throws SQLException {
        List<Passager> passagers = new ArrayList<>();
        String sql = "SELECT * FROM passagers";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String email = resultSet.getString("email");
                String passeport = resultSet.getString("passeport");

                Passager passager = new Passager(id, nom, email, passeport);
                passagers.add(passager);
            }
        }

        return passagers;
    }
}
