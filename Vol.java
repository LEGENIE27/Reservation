public class Vol {
    private String numeroVol;
    private String destination;
    private String dateDepart;
    private String heureDepart;
    private String heureArrivee;

    public Vol(String numeroVol, String destination, String dateDepart, String heureDepart, String heureArrivee) {
        this.numeroVol = numeroVol;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public void afficherDetails() {
        System.out.println("Vol " + numeroVol + " vers " + destination + " - Départ: " + dateDepart +
                           " à " + heureDepart + " - Arrivée: " + heureArrivee);
    }
}
