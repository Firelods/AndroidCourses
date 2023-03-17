package edu.clementlefevre.exo4td3;

public enum Ingredients {
    FROMAGE("Fromage", 1, "g"),
    CHAMPIGNONS("Champignons", 1, "g"),
    OLIVES("Olives", 1, "");

    public final String name;
    public final int quantity;
    public final String unit;

    Ingredients(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }
}
