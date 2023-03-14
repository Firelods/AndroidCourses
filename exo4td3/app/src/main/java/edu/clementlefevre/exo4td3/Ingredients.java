package edu.clementlefevre.exo4td3;

public enum Ingredients {
    FROMAGE("Fromage" ,50,"g"),
    CHAMPIGNONS("Champignons",80, "g"),
    OLIVES("Olives",3, "");

    public final String name;
    public int quantity;
    public final String unit;

    Ingredients(String name,int quantity, String unit) {

        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }
}
