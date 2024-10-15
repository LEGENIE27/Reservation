package model;

import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private final Connection connection;

    public Login() throws SQLException {
        this.connection = DatabaseConnection.getConnection(); // Connexion à la base de données
    }

    // Méthode pour vérifier si les identifiants sont corrects
    public boolean validateUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            // Si un enregistrement est trouvé, l'utilisateur est valide
            return resultSet.next();
        }
    }

    // Méthode pour vérifier si l'utilisateur est admin
    public boolean isAdmin(String username) throws SQLException {
        String query = "SELECT is_admin FROM users WHERE username = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            // Si l'utilisateur est trouvé et que son champ is_admin est vrai
            return resultSet.next() && resultSet.getBoolean("is_admin");
        }
    }
}
