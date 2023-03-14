package edu.clementlefevre.exo4td3;

public class Pizza {
    private String nom;
    private int image;
    private float price;

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    private float originalPrice;
    private Ingredients[] listIngredients;

    public Pizza(String nom, int image, float price) {
        this.nom = nom;
        this.image = image;
        this.price = price;
        this.originalPrice = price;
        this.listIngredients = new Ingredients[3];
        this.listIngredients[0] = Ingredients.FROMAGE;
        this.listIngredients[1] = Ingredients.CHAMPIGNONS;
        this.listIngredients[2] = Ingredients.OLIVES;
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

    public Ingredients[] getIngredients() {
        return listIngredients;
    }
}
