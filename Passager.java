public class Passager {
    private String nom;
    private String email;
    private String numeroPasseport;

    public Passager(String nom, String email, String numeroPasseport) {
        this.nom = nom;
        this.email = email;
        this.numeroPasseport = numeroPasseport;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroPasseport() {
        return numeroPasseport;
    }

    public void setNumeroPasseport(String numeroPasseport) {
        this.numeroPasseport = numeroPasseport;
    }

    public void afficherDetailsPassager() {
        System.out.println("Passager: " + nom + " - Email: " + email + " - Passeport: " + numeroPasseport);
    }
}
