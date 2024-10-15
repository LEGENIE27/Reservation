package dao;

import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final Connection connection;

    public UserDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("is_admin")
            );
        }
        return null;
    }

    public boolean validateLogin(String username, String password) throws SQLException {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean isAdmin(String username) throws SQLException {
        User user = getUserByUsername(username);
        return user != null && user.isAdmin();
    }
}
