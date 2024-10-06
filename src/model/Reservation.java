package model;

import java.util.Date;

public class Reservation {
    private int id;
    private int volId; // Référence au vol
    private int passagerId; // Référence au passager
    private Date dateReservation;
    private String statut; // Confirmée, annulée, etc.

    public Reservation(int id, int volId, int passagerId, Date dateReservation, String statut) {
        this.id = id;
        this.volId = volId;
        this.passagerId = passagerId;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVolId() { return volId; }
    public void setVolId(int volId) { this.volId = volId; }

    public int getPassagerId() { return passagerId; }
    public void setPassagerId(int passagerId) { this.passagerId = passagerId; }

    public Date getDateReservation() { return dateReservation; }
    public void setDateReservation(Date dateReservation) { this.dateReservation = dateReservation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
