package model;

import java.sql.Time;
import java.sql.Date; // Remplace java.util.Date par java.sql.Date

public class Vol {
    private int id;
    private String numeroVol;
    private String destination;
    private Date dateDepart;  // Utilisation de java.sql.Date
    private Time heureDepart;
    private Time heureArrivee;
    private int agenceId; // Référence à l'agence

    public Vol(int id, String numeroVol, String destination, Date dateDepart, Time heureDepart, Time heureArrivee, int agenceId) {
        this.id = id;
        this.numeroVol = numeroVol;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.agenceId = agenceId;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumeroVol() { return numeroVol; }
    public void setNumeroVol(String numeroVol) { this.numeroVol = numeroVol; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Date getDateDepart() { return dateDepart; }
    public void setDateDepart(Date dateDepart) { this.dateDepart = dateDepart; }

    public Time getHeureDepart() { return heureDepart; }
    public void setHeureDepart(Time heureDepart) { this.heureDepart = heureDepart; }

    public Time getHeureArrivee() { return heureArrivee; }
    public void setHeureArrivee(Time heureArrivee) { this.heureArrivee = heureArrivee; }

    public int getAgenceId() { return agenceId; }
    public void setAgenceId(int agenceId) { this.agenceId = agenceId; }
}
