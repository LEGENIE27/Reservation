package dao;

import model.Reservation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Reservation reservation = new Reservation(
                rs.getInt("id"),
                rs.getInt("vol_id"),
                rs.getInt("passager_id"),
                rs.getDate("date_reservation"),
                rs.getString("statut")
            );
            reservations.add(reservation);
        }
        return reservations;
    }

    public void insertReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations (vol_id, passager_id, date_reservation, statut) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, reservation.getVolId());
        pstmt.setInt(2, reservation.getPassagerId());
        pstmt.setDate(3, new java.sql.Date(reservation.getDateReservation().getTime()));
        pstmt.setString(4, reservation.getStatut());
        pstmt.executeUpdate();
    }

    // Méthodes de mise à jour et suppression
}
