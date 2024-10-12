package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
    
    private static Connection connection = null;
    
    public static Connection getConnection() {
        if (connection == null) {
            System.out.println("Tentative de connexion à la base de données...");
            try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
                
                if (input == null) {
                    System.out.println("Le fichier config.properties est manquant !");
                    throw new IOException("Fichier de configuration non trouvé.");
                } else {
                    System.out.println("Le fichier config.properties est trouvé.");
                }
                
                System.out.println("Lecture des propriétés du fichier config.properties...");
                
                // Charger les configurations à partir d'un fichier config.properties
                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                // Charger le driver JDBC
                System.out.println("Chargement du driver JDBC...");
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Etablir la connexion
                System.out.println("Tentative d'établissement de la connexion avec la base de données...");
                connection = DriverManager.getConnection(url, user, password);

                // Afficher un message de confirmation si la connexion réussit
                System.out.println("Connexion à la base de données réussie.");
                
                // Vérification de l'auto-commit
                boolean autoCommit = connection.getAutoCommit();
                System.out.println("Auto-commit activé : " + autoCommit);
                
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC non trouvé : " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Erreur de lecture du fichier de configuration : " + e.getMessage());
            }
        }
        
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
    
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.err.println("La connexion est nulle. Impossible de tester la connexion.");
                return false;
            }
            
            try (PreparedStatement stmt = conn.prepareStatement("SELECT 1");
                 ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si la requête réussit et retourne une ligne, la connexion est bonne.
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du test de la connexion : " + e.getMessage());
            return false; // La connexion a échoué
        }
    }

    public static void main(String[] args) {
        // Tester la connexion à la base de données
        if (testConnection()) {
            System.out.println("La connexion à la base de données est active.");
        } else {
            System.out.println("La connexion à la base de données a échoué.");
        }
        
        // Fermer la connexion après le test
        closeConnection();
    }
}
