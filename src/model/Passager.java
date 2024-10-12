package model;

public class Passager {
    private int id;  // ID auto-incrémenté par la base de données
    private String nom;
    private String email;
    private String passeport;

    // Constructeur sans id (utilisé lors de la création avant que l'id soit attribué)
    public Passager(String nom, String email, String passeport) {
        this.nom = nom;
        this.email = email;
        this.passeport = passeport;
    }

    // Constructeur avec id (utilisé lorsque l'id est connu, par ex. lors de la récupération depuis la BDD)
    public Passager(int id, String nom, String email, String passeport) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.passeport = passeport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", passeport='" + passeport + '\'' +
                '}';
    }
}
