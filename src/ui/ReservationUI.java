package ui;
import javax.swing.*;
import java.awt.*;

public class ReservationUI extends JFrame {
    public ReservationUI() {
        // Configuration de la fenêtre
        this.setTitle("Réservation de Vol");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        // Champs pour les détails de réservation
        JLabel labelNom = new JLabel("Nom du passager:");
        JTextField nomField = new JTextField(20);
        
        JLabel labelVol = new JLabel("Numéro du vol:");
        JTextField volField = new JTextField(20);
        
        // Bouton de réservation
        JButton reserverButton = new JButton("Réserver");

        // Ajout des composants
        this.add(labelNom);
        this.add(nomField);
        this.add(labelVol);
        this.add(volField);
        this.add(reserverButton);
    }
}
