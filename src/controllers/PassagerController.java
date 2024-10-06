package controllers;

import model.Passager;
import service.PassagerService;

import java.sql.SQLException;

public class PassagerController {
    private final PassagerService passagerService;

    public PassagerController(PassagerService passagerService) {
        this.passagerService = passagerService;
    }

    // Méthode pour créer un nouveau passager
    public void creerNouveauPassager(Passager passager) {
        try {
            passagerService.ajouterPassager(passager);
            System.out.println("Le passager a été créé avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création du passager : " + e.getMessage());
        }
    }

    // Méthode pour afficher tous les passagers
    public void afficherTousLesPassagers() {
        try {
            passagerService.obtenirTousLesPassagers().forEach(System.out::println);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des passagers : " + e.getMessage());
        }
    }
}
