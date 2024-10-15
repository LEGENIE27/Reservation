package ui;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private final JButton passagerButton;
    private final JButton rechercheVolButton;
    private final JButton reservationButton;
    private final JButton gestionVolsButton;

    public MainUI(boolean isAdmin) {
        setTitle("Système de Réservation de Voyages");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1)); // Organise les boutons verticalement

        // Bouton pour la gestion des passagers
        passagerButton = new JButton("Gestion des Passagers");
        passagerButton.addActionListener(e -> {
            PassagerUI passagerUI = new PassagerUI();  // Ouvre la fenêtre de gestion des passagers
            passagerUI.setVisible(true);
        });
        add(passagerButton);

        // Bouton pour la recherche de vols
        rechercheVolButton = new JButton("Recherche de Vols");
        rechercheVolButton.addActionListener(e -> {
            RechercheVolUI rechercheVolUI = new RechercheVolUI();  // Ouvre la fenêtre de recherche de vols
            rechercheVolUI.setVisible(true);
        });
        add(rechercheVolButton);

        // Bouton pour la gestion des réservations
        reservationButton = new JButton("Gestion des Réservations");
        reservationButton.addActionListener(e -> {
            ReservationUI reservationUI = new ReservationUI();  // Ouvre la fenêtre de gestion des réservations
            reservationUI.setVisible(true);
        });
        add(reservationButton);

        // Bouton pour la gestion des vols, seulement accessible si admin
        gestionVolsButton = new JButton("Gestion des Vols");
        gestionVolsButton.addActionListener(e -> {
            VolUI volUI = new VolUI();  // Ouvre la fenêtre de gestion des vols
            volUI.setVisible(true);
        });

        // Si l'utilisateur est un admin, afficher le bouton de gestion des vols
        if (isAdmin) {
            add(gestionVolsButton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            boolean isAdmin = MainUI.login();  // Appel de la méthode login pour obtenir le statut admin
            System.out.println("Statut Admin: " + isAdmin); // Affiche le statut admin
            MainUI mainUI = new MainUI(isAdmin); // Passer le statut admin à l'interface principale
            mainUI.setVisible(true);
        });
    }

    // Exemple de méthode de connexion
    public static boolean login() {
        // Remplace par ta logique de connexion
        String username = JOptionPane.showInputDialog("Nom d'utilisateur :");
        String password = JOptionPane.showInputDialog("Mot de passe :");

        // Vérifie les informations d'identification (exemple simple)
        return "admin".equals(username) && "adminpass".equals(password); // Remplace par tes vraies valeurs
    }
}
