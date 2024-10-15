package ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolUI extends JFrame {

    private final JTextField numeroVolField;
    private final JTextField destinationField;
    private final JTextField dateDepartField;
    private final JTextField heureDepartField;
    private final JTextField heureArriveeField;
    private final JTextField agenceIdField;
    private final JButton creerVolButton;
    private final JTextArea volListArea;

    public VolUI() {
        setTitle("Gestion des Vols");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1)); // Organise les éléments verticalement

        // Champs pour les informations du vol
        numeroVolField = new JTextField();
        destinationField = new JTextField();
        dateDepartField = new JTextField();
        heureDepartField = new JTextField();
        heureArriveeField = new JTextField();
        agenceIdField = new JTextField();

        // Bouton pour créer un vol
        creerVolButton = new JButton("Créer un Vol");
        // Utilisation d'une expression lambda
        creerVolButton.addActionListener(e -> creerVol());

        // Zone de texte pour afficher la liste des vols
        volListArea = new JTextArea();
        volListArea.setEditable(false);
        volListArea.setLineWrap(true);
        volListArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(volListArea);

        // Ajout des éléments à l'interface
        add(new JLabel("Numéro de Vol:"));
        add(numeroVolField);
        add(new JLabel("Destination:"));
        add(destinationField);
        add(new JLabel("Date de Départ:"));
        add(dateDepartField);
        add(new JLabel("Heure de Départ:"));
        add(heureDepartField);
        add(new JLabel("Heure d'Arrivée:"));
        add(heureArriveeField);
        add(new JLabel("ID Agence:"));
        add(agenceIdField);
        add(creerVolButton);
        add(scrollPane); // Ajout de la zone de texte dans un JScrollPane

        // Exemple d'ajout de vols pour tester
        volListArea.setText("Liste des vols créés:\n");
    }

    private void creerVol() {
        String numeroVol = numeroVolField.getText();
        String destination = destinationField.getText();
        String dateDepart = dateDepartField.getText();
        String heureDepart = heureDepartField.getText();
        String heureArrivee = heureArriveeField.getText();
        String agenceId = agenceIdField.getText();

        if (numeroVol.isEmpty() || destination.isEmpty() || dateDepart.isEmpty() || 
            heureDepart.isEmpty() || heureArrivee.isEmpty() || agenceId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insérer le vol dans la base de données
        if (insertVolIntoDatabase(numeroVol, destination, dateDepart, heureDepart, heureArrivee, agenceId)) {
            // Ajouter le vol à la zone de texte
            volListArea.append("Vol: " + numeroVol + ", Destination: " + destination + 
                               ", Date: " + dateDepart + ", Heure Départ: " + heureDepart + 
                               ", Heure Arrivée: " + heureArrivee + ", Agence ID: " + agenceId + "\n");

            // Effacer les champs
            numeroVolField.setText("");
            destinationField.setText("");
            dateDepartField.setText("");
            heureDepartField.setText("");
            heureArriveeField.setText("");
            agenceIdField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Échec de l'insertion dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean insertVolIntoDatabase(String numeroVol, String destination, String dateDepart,
                                          String heureDepart, String heureArrivee, String agenceId) {
        String url = "jdbc:mysql://localhost:3306/billets"; // Remplacez par l'URL de votre base de données
        String user = "root"; // Remplacez par votre nom d'utilisateur
        String password = "Admin"; // Remplacez par votre mot de passe

        String query = "INSERT INTO vols (numero_vol, destination, date_depart, heure_depart, heure_arrivee, agence_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, numeroVol);
            pstmt.setString(2, destination);
            pstmt.setString(3, dateDepart);
            pstmt.setString(4, heureDepart);
            pstmt.setString(5, heureArrivee);
            pstmt.setInt(6, Integer.parseInt(agenceId)); // Convertir l'ID d'agence en entier

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Retourne true si des lignes ont été insérées
        } catch (SQLException e) {
            // Afficher un message d'erreur
            JOptionPane.showMessageDialog(null, "Erreur de base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            return false; // Retourne false en cas d'erreur
        }
    }
}
