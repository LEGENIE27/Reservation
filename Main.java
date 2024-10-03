public class Main {
    public static void main(String[] args) {
        // Créer un vol
        Vol vol1 = new Vol("AF123", "Paris", "2024-10-10", "14:00:00", "16:00:00");

        // Afficher les détails du vol
        vol1.afficherDetails();

        // Modifier la destination du vol
        vol1.setDestination("Londres");

        // Réafficher les détails du vol après modification
        vol1.afficherDetails();

        // Créer un passager
        Passager passager1 = new Passager("Fidel TINDANAHIRE", "fideltindanahire.226@gmail.com", "X123456");

        // Afficher les détails du passager
        passager1.afficherDetailsPassager();

        // Créer une réservation associée au passager et au vol
        Reservation reservation1 = new Reservation(vol1, passager1, "Confirmée");

        // Afficher les détails de la réservation
        reservation1.afficherDetailsReservation();

        // Modifier le statut de la réservation
        reservation1.setStatut("Annulée");

        // Réafficher les détails de la réservation après modification
        reservation1.afficherDetailsReservation();
    }
}
