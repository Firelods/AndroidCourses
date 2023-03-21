package edu.clementlefevre.td5exo2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String nom;
    private int image;
    private float price;
    List<Ingredient> listIngredients;
    private float originalPrice;


    public Pizza(String nom, int prix, int image, ArrayList<Ingredient> listIngredient) {
        this.nom = nom;
        this.price = prix;
        this.originalPrice = prix;
        this.image = image;
        this.listIngredients = listIngredient;

    }




    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
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

    public List<Ingredient> getIngredients() {
        return listIngredients;
    }
}
