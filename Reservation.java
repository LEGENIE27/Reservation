public class Reservation {
    private Vol vol;
    private Passager passager;
    private String statut; // Confirmée, Annulée, En attente

    public Reservation(Vol vol, Passager passager, String statut) {
        this.vol = vol;
        this.passager = passager;
        this.statut = statut;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void afficherDetailsReservation() {
        System.out.println("Réservation pour " + passager.getNom() + " sur le vol " + vol.getNumeroVol() +
                           " vers " + vol.getDestination() + " - Statut: " + statut);
    }
}
