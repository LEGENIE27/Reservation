package service;

import dao.PassagerDAO;
import model.Passager;

import java.sql.SQLException;
import java.util.List;

public class PassagerService {
    private final PassagerDAO passagerDAO;

    public PassagerService(PassagerDAO passagerDAO) {
        this.passagerDAO = passagerDAO;
    }

    // Méthode pour ajouter un passager
    public void ajouterPassager(Passager passager) throws SQLException {
        passagerDAO.ajouterPassager(passager);
    }

    // Nouvelle méthode pour récupérer tous les passagers
    public List<Passager> obtenirTousLesPassagers() throws SQLException {
        return passagerDAO.obtenirTousLesPassagers();
    }
}
