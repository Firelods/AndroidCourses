package edu.clementlefevre.td5exo2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Ingredient implements Parcelable {

    public Item item;
    public float quantity;
    public String unit;

    Ingredient(Item item,int quantity, String unit) {
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
    }
    Ingredient(Item item,float quantity, String unit) {
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
    }

    protected Ingredient(Parcel in) {
        item = Item.valueOf(in.readString());
        quantity = in.readFloat();
        unit = in.readString();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(item.toString());
        parcel.writeFloat(quantity);
        parcel.writeString(unit);
    }
}
