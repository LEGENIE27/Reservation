package ui;

import service.LoginService;
import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;

    private final LoginService loginService;

    public LoginUI() {
        loginService = new LoginService();

        setTitle("Connexion");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Nom d'utilisateur:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Connexion");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (loginService.login(username, password)) {
                boolean isAdmin = loginService.isAdmin(username);
                JOptionPane.showMessageDialog(this, "Connexion réussie !");
                MainUI mainUI = new MainUI(isAdmin); // Utilise le constructeur avec isAdmin
                mainUI.setVisible(true);
                dispose(); // Ferme la fenêtre de login
            } else {
                JOptionPane.showMessageDialog(this, "Identifiants incorrects.");
            }
        });
        panel.add(loginButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().setVisible(true));
    }
}
