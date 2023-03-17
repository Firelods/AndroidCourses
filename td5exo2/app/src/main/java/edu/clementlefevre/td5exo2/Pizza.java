package edu.clementlefevre.td5exo2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Pizza implements Parcelable {
    private String nom;
    private int image;
    private float price;

    protected Pizza(Parcel in) {
        nom = in.readString();
        image = in.readInt();
        price = in.readFloat();
        originalPrice = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(image);
        dest.writeFloat(price);
        dest.writeFloat(originalPrice);
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

    private float originalPrice;
    private ArrayList<Item> listIngredients;

    public Pizza(String nom, int image, float price) {
        this.nom = nom;
        this.image = image;
        this.price = price;
        this.originalPrice = price;
        this.listIngredients = new ArrayList<>();
        this.listIngredients.add(Item.FROMAGE);
        this.listIngredients.add(Item.CHAMPIGNONS);
        this.listIngredients.add(Item.OLIVES);


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

    public Item[] getIngredients() {
        return listIngredients;
    }
}
