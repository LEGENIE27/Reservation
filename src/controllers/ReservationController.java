package controllers;

import model.Reservation;
import service.ReservationService;

import java.sql.SQLException;
import java.util.List;

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<Reservation> afficherToutesLesReservations() throws SQLException {
        return reservationService.obtenirToutesLesReservations();
    }

    public void creerNouvelleReservation(Reservation reservation) throws SQLException {
        reservationService.ajouterReservation(reservation);
    }
}
