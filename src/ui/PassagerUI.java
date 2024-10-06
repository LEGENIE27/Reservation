package ui;

import javax.swing.*;
import java.awt.*;
import model.Passager;  // Utilise le modèle de passager

public class PassagerUI extends JFrame {
    private final JButton creerPassagerButton;
    private JTextField nomField, emailField, passeportField;

    public PassagerUI() {
        setTitle("Gestion des Passagers");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Champs de saisie
        panel.add(new JLabel("Nom:"));
        nomField = new JTextField();
        panel.add(nomField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Passeport:"));
        passeportField = new JTextField();
        panel.add(passeportField);

        // Bouton pour créer un passager
        creerPassagerButton = new JButton("Créer Passager");
        panel.add(creerPassagerButton);

        add(panel);

        // Action lors du clic du bouton
        creerPassagerButton.addActionListener(e -> {
            String nom = nomField.getText();
            String email = emailField.getText();
            String passeport = passeportField.getText();

            // Créer et manipuler un objet Passager
            Passager nouveauPassager = new Passager(0, nom, email, passeport);
            System.out.println("Nouveau passager créé: " + nouveauPassager);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PassagerUI().setVisible(true);
        });
    }
}
