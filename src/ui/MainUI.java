package ui;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private final JButton passagerButton;
    private final JButton rechercheVolButton;
    private final JButton reservationButton;

    public MainUI() {
        setTitle("Système de réservation de voyages");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1)); // Pour organiser les boutons verticalement

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
    }
}
