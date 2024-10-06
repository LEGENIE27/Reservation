package model;

public class Passager {
    private int id;
    private String nom;
    private String email;
    private String passeport;

    // Constructeur
    public Passager(int id, String nom, String email, String passeport) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.passeport = passeport;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasseport() { return passeport; }
    public void setPasseport(String passeport) { this.passeport = passeport; }

    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
        return "Passager{id=" + id + 
               ", nom='" + nom + '\'' + 
               ", email='" + email + '\'' + 
               ", passeport='" + passeport + '\'' + 
               '}';
    }
}
