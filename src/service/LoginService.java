package service;

import dao.UserDAO;

import java.sql.SQLException;

public class LoginService {
    private final UserDAO userDAO;

    public LoginService() {
        userDAO = new UserDAO();
    }

    public boolean login(String username, String password) {
        try {
            return userDAO.validateLogin(username, password);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée (log, relancer, etc.)
            System.err.println("Erreur lors de la validation de l'utilisateur : " + e.getMessage());
            // Optionnel : logger l'erreur dans un fichier ou un système de logging
        }
        return false;
    }

    public boolean isAdmin(String username) {
        try {
            return userDAO.isAdmin(username);
        } catch (SQLException e) {
            // Gérer l'exception de manière appropriée (log, relancer, etc.)
            System.err.println("Erreur lors de la vérification des droits d'administration : " + e.getMessage());
            // Optionnel : logger l'erreur dans un fichier ou un système de logging
        }
        return false;
    }
}
