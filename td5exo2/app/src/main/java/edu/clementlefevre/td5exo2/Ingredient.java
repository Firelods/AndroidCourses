package edu.clementlefevre.td5exo2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Ingredient {

    public Item item;
    public float quantity;
    public String unit;

    Ingredient(Item item, int quantity, String unit) {
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
    }

    Ingredient(Item item, float quantity, String unit) {
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
    }

    protected Ingredient(Parcel in) {
        item = Item.valueOf(in.readString());
        quantity = in.readFloat();
        unit = in.readString();
    }




}
