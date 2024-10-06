package service;

import dao.VolDAO;
import model.Vol;

import java.sql.SQLException;
import java.util.List;

public class VolService {
    private final VolDAO volDAO;

    public VolService(VolDAO volDAO) {
        this.volDAO = volDAO;
    }

    public List<Vol> obtenirTousLesVols() throws SQLException {
        return volDAO.getAllVols();
    }

    public void ajouterVol(Vol vol) throws SQLException {
        volDAO.insertVol(vol);
    }
}
