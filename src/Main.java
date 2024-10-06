import controllers.*;
import model.*;
import service.*;
import dao.*;

import ui.PassagerUI;
import ui.RechercheVolUI;
import ui.ReservationUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billets", "root", "Admin");

            // DAO et Services
            AgenceDAO agenceDAO = new AgenceDAO(connection);
            AgenceService agenceService = new AgenceService(agenceDAO);

            PassagerDAO passagerDAO = new PassagerDAO(connection);
            PassagerService passagerService = new PassagerService(passagerDAO);

            VolDAO volDAO = new VolDAO(connection);
            VolService volService = new VolService(volDAO);

            ReservationDAO reservationDAO = new ReservationDAO(connection);
            ReservationService reservationService = new ReservationService(reservationDAO);

            // Controllers
            AgenceController agenceController = new AgenceController(agenceService);
            PassagerController passagerController = new PassagerController(passagerService);
            VolController volController = new VolController(volService);
            ReservationController reservationController = new ReservationController(reservationService);

            // Ajouter une nouvelle agence
            Agence nouvelleAgence = new Agence(0, "Agence Air France", "contact@airfrance.com", "Promo d'été");
            agenceController.creerNouvelleAgence(nouvelleAgence);

            // Ajouter un nouveau passager
            Passager nouveauPassager = new Passager(0, "Jean Dupont", "jean.dupont@example.com", "P1234567");
            passagerController.creerNouveauPassager(nouveauPassager);

            // Afficher toutes les agences
            System.out.println("Liste des agences : ");
            agenceController.afficherToutesLesAgences();

            // Afficher tous les passagers
            System.out.println("Liste des passagers : ");
            passagerController.afficherTousLesPassagers();

            // Utiliser le volController pour afficher tous les vols
            System.out.println("Liste des vols : ");
            volController.afficherTousLesVols();

            // Utiliser le reservationController pour afficher toutes les réservations
            System.out.println("Liste des réservations : ");
            reservationController.afficherToutesLesReservations();

            // **Appel des interfaces graphiques**
            // Interface de gestion des passagers
            SwingUtilities.invokeLater(() -> {
                PassagerUI passagerUI = new PassagerUI();
                passagerUI.setVisible(true);
            });

            // Interface de recherche de vols
            SwingUtilities.invokeLater(() -> {
                RechercheVolUI rechercheVolUI = new RechercheVolUI();
                rechercheVolUI.setVisible(true);
            });

            // Interface de gestion des réservations
            SwingUtilities.invokeLater(() -> {
                ReservationUI reservationUI = new ReservationUI();
                reservationUI.setVisible(true);
            });

        } catch (SQLException e) {
            // Utilisez un système de logging ici, ou imprimez un message d'erreur plus descriptif
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } finally {
            // Fermer la connexion si elle a été établie
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }
}
