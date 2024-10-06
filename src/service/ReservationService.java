package service;

import dao.ReservationDAO;
import model.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {
    private final ReservationDAO reservationDAO;

    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public List<Reservation> obtenirToutesLesReservations() throws SQLException {
        return reservationDAO.getAllReservations();
    }

    public void ajouterReservation(Reservation reservation) throws SQLException {
        reservationDAO.insertReservation(reservation);
    }
}
