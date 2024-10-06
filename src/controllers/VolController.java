package controllers;

import model.Vol;
import service.VolService;

import java.sql.SQLException;
import java.util.List;

public class VolController {
    private final VolService volService;

    public VolController(VolService volService) {
        this.volService = volService;
    }

    public List<Vol> afficherTousLesVols() throws SQLException {
        return volService.obtenirTousLesVols();
    }

    public void creerNouveauVol(Vol vol) throws SQLException {
        volService.ajouterVol(vol);
    }
}
