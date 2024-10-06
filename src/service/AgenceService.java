package service;

import dao.AgenceDAO;
import model.Agence;
import java.sql.SQLException;
import java.util.List;

public class AgenceService {
    private final  AgenceDAO agenceDAO;

    public AgenceService(AgenceDAO agenceDAO) {
        this.agenceDAO = agenceDAO;
    }

    public List<Agence> obtenirToutesLesAgences() throws SQLException {
        return agenceDAO.getAllAgences();
    }

    public void ajouterAgence(Agence agence) throws SQLException {
        agenceDAO.insertAgence(agence);
    }
}
