import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Méthode pour établir la connexion avec MySQL
    public static Connection getConnection() {
        Connection connection = null;

        // Paramètres de connexion
        String url = "jdbc:mysql://localhost:3306/billets"; 
        String user = "root"; 
        String password = "Admin";

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        // Tester la connexion
        Connection connection = getConnection();

        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
