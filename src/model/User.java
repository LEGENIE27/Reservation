package model;

public class User {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    // Constructeur
    public User(int id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password; // Considérer le hashage du mot de passe au lieu de le stocker en clair
        this.isAdmin = isAdmin;
    }

    // Getters
    public int getId() { 
        return id; 
    }

    public String getUsername() { 
        return username; 
    }

    public String getPassword() { 
        return password; // Envisager de ne pas exposer le mot de passe directement
    }

    public boolean isAdmin() { 
        return isAdmin; 
    }

    // Setters
    public void setId(int id) { 
        this.id = id; 
    }

    public void setUsername(String username) { 
        this.username = username; 
    }

    public void setPassword(String password) { 
        this.password = password; // Assurez-vous de gérer les mots de passe de manière sécurisée
    }

    public void setAdmin(boolean admin) { 
        isAdmin = admin; 
    }
}
