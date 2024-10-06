package controllers;

import model.Agence;
import service.AgenceService;

import java.sql.SQLException;
import java.util.List;

public class AgenceController {
    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    public List<Agence> afficherToutesLesAgences() throws SQLException {
        return agenceService.obtenirToutesLesAgences();
    }

    public void creerNouvelleAgence(Agence agence) throws SQLException {
        agenceService.ajouterAgence(agence);
    }
}
