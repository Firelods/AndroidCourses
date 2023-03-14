package edu.clementlefevre.exo2td3;

public class Personnage {
    private String nom;
    private String description;
    private int image;

    public Personnage(String nom, String description, int image) {
        this.nom = nom;
        this.description = description;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
