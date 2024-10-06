package dao;

import model.Agence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenceDAO {
    private final Connection connection;

    public AgenceDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Agence> getAllAgences() throws SQLException {
        List<Agence> agences = new ArrayList<>();
        String query = "SELECT * FROM agences";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Agence agence = new Agence(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("contact"),
                rs.getString("offres_speciales")
            );
            agences.add(agence);
        }
        return agences;
    }

    public void insertAgence(Agence agence) throws SQLException {
        String query = "INSERT INTO agences (nom, contact, offres_speciales) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, agence.getNom());
        pstmt.setString(2, agence.getContact());
        pstmt.setString(3, agence.getOffresSpeciales());
        pstmt.executeUpdate();
    }

    // Méthodes de mise à jour et suppression peuvent être ajoutées ici
}
