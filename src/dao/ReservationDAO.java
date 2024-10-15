package dao;

import model.Reservation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private final Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour obtenir toutes les réservations
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

    // Méthode pour insérer une nouvelle réservation
    public void insertReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations (vol_id, passager_id, date_reservation, statut) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, reservation.getVolId());
        pstmt.setInt(2, reservation.getPassagerId());
        pstmt.setDate(3, new java.sql.Date(reservation.getDateReservation().getTime()));
        pstmt.setString(4, reservation.getStatut());
        pstmt.executeUpdate();
    }

    // Méthode pour mettre à jour le statut d'une réservation (confirmée, annulée, etc.)
    public void updateReservationStatus(int reservationId, String newStatus) throws SQLException {
        String query = "UPDATE reservations SET statut = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, newStatus);
        pstmt.setInt(2, reservationId);
        pstmt.executeUpdate();
    }

    // Méthode pour supprimer une réservation par son ID
    public void deleteReservation(int reservationId) throws SQLException {
        String query = "DELETE FROM reservations WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, reservationId);
        pstmt.executeUpdate();
    }

    // Méthode pour rechercher une réservation par son ID
    public Reservation getReservationById(int reservationId) throws SQLException {
        String query = "SELECT * FROM reservations WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, reservationId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Reservation(
                rs.getInt("id"),
                rs.getInt("vol_id"),
                rs.getInt("passager_id"),
                rs.getDate("date_reservation"),
                rs.getString("statut")
            );
        } else {
            return null; // Si aucune réservation n'est trouvée
        }
    }
}
