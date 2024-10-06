package ui;
import javax.swing.*;
import java.awt.*;

public class RechercheVolUI extends JFrame {
    public RechercheVolUI() {
        // Configuration de la fenêtre
        this.setTitle("Recherche de Vols");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        // Champs de texte pour la recherche
        JLabel label = new JLabel("Entrez votre destination:");
        JTextField destinationField = new JTextField(20);
        
        // Bouton de recherche
        JButton searchButton = new JButton("Rechercher");
        
        // Ajout des composants
        this.add(label);
        this.add(destinationField);
        this.add(searchButton);
    }
}
