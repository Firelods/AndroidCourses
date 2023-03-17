package edu.clementlefevre.exo4td3;

public class Pizza {
    private String nom;
    private int image;
    private float price;
    public Pizza(String nom, int image, float price) {
        this.nom = nom;
        this.image = image;
        this.price = price;
    }

    public String getNom() {
        return nom;

    }



    public int getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
