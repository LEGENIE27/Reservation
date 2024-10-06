package model;

public class Agence {
    private int id;
    private String nom;
    private String contact;
    private String offresSpeciales;

    // Constructeur
    public Agence(int id, String nom, String contact, String offresSpeciales) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
        this.offresSpeciales = offresSpeciales;
    }

    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
        return "Agence{id=" + id + 
               ", nom='" + nom + '\'' + 
               ", contact='" + contact + '\'' + 
               ", offresSpeciales='" + offresSpeciales + '\'' + 
               '}';
    }
    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getOffresSpeciales() { return offresSpeciales; }
    public void setOffresSpeciales(String offresSpeciales) { this.offresSpeciales = offresSpeciales; }
}
