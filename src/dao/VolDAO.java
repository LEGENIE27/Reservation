package dao;

import model.Vol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolDAO {
    private final Connection connection;

    public VolDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Vol> getAllVols() throws SQLException {
        List<Vol> vols = new ArrayList<>();
        String query = "SELECT * FROM vols";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Vol vol = new Vol(
                rs.getInt("id"),
                rs.getString("numero_vol"),
                rs.getString("destination"),
                rs.getDate("date_depart"),
                rs.getTime("heure_depart"),
                rs.getTime("heure_arrivee"),
                rs.getInt("agence_id")
            );
            vols.add(vol);
        }
        return vols;
    }

    public void insertVol(Vol vol) throws SQLException {
        String query = "INSERT INTO vols (numero_vol, destination, date_depart, heure_depart, heure_arrivee, agence_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, vol.getNumeroVol());
        pstmt.setString(2, vol.getDestination());
        pstmt.setDate(3, new java.sql.Date(vol.getDateDepart().getTime()));
        pstmt.setTime(4, vol.getHeureDepart());
        pstmt.setTime(5, vol.getHeureArrivee());
        pstmt.setInt(6, vol.getAgenceId());
        pstmt.executeUpdate();
    }

    // Méthodes de mise à jour et suppression peuvent être ajoutées ici
    
}
