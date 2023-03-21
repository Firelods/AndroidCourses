package edu.clementlefevre.td5exo2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements Parcelable {
    private String nom;
    private int image;
    private float price;
    List<Ingredient> listIngredients;
    private float originalPrice;

    protected Pizza(Parcel in) {
        nom = in.readString();
        image = in.readInt();
        price = in.readFloat();
        originalPrice = in.readFloat();
        listIngredients = in.createTypedArrayList(Ingredient.CREATOR);
    }

    public Pizza(String nom, int prix, int image, ArrayList<Ingredient> listIngredient) {
        this.nom = nom;
        this.price = prix;
        this.originalPrice = prix;
        this.image = image;
        this.listIngredients = listIngredient;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(image);
        dest.writeFloat(price);
        dest.writeFloat(originalPrice);
        dest.writeTypedList(listIngredients);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

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
