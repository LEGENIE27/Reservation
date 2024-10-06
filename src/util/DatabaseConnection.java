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
            try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
                
                if (input == null) {
                    throw new IOException("Fichier de configuration non trouvé.");
                }
                
                // Charger les configurations à partir d'un fichier config.properties
                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                // Charger le driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Etablir la connexion
                connection = DriverManager.getConnection(url, user, password);
                
            } catch (ClassNotFoundException e) {
                // Utilisez un système de logging ici
                System.err.println("Driver JDBC non trouvé : " + e.getMessage());
            } catch (SQLException e) {
                // Utilisez un système de logging ici
                System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            } catch (IOException e) {
                // Utilisez un système de logging ici
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
            } catch (SQLException e) {
                // Utilisez un système de logging ici
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
    
    public static boolean testConnection() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT 1");
             ResultSet rs = stmt.executeQuery()) {
            return rs.next(); // Si la requête réussit et retourne une ligne, la connexion est bonne.
        } catch (SQLException e) {
            // Utilisez un système de logging ici
            System.err.println("Erreur lors du test de la connexion : " + e.getMessage());
            return false; // La connexion a échoué
        }
    }
}
