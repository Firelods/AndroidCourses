package edu.clementlefevre.td5exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // collect the pizza object from the intent
        Pizza pizza = (Pizza) getIntent().getParcelableExtra("pizza");

        ImageView imageView = findViewById(R.id.pizzaImage);
        imageView.setImageResource(pizza.getImage());
        TextView prixText = findViewById(R.id.prixTotalPizza);
        prixText.setText(pizza.getPrice() + "€");
        TextView textView = findViewById(R.id.pizzaTitle);
        textView.setText(pizza.getNom());

        ListView ingredientsContainer = findViewById(R.id.listIngredients);

        List<Ingredient> ingredients = pizza.getIngredients();
        // use the basic adapter to display the ingredients
        // construct a list of string with ingredient and their quantities
        List<String> ingredientsString = new ArrayList<>();
        for (int i = 0; i < ingredients.size(); i++) {
            ingredientsString.add(ingredients.get(i).item + " : " + ingredients.get(i).quantity + "g");
            if (ingredients.get(i).item == Item.FROMAGE) {

                ingredientsString.add("Extras Fromage : " + String.format("%.2f", (ingredients.get(i).quantity - 50) * 0.05f) + "€");
            }
            if (ingredients.get(i).item == Item.OLIVE) {
                ingredientsString.add("Extras Olives : " + String.format("%.2f", (ingredients.get(i).quantity - 3) * 0.2f) + "€");
            }
            if (ingredients.get(i).item == Item.CHAMPIGNON) {
                ingredientsString.add("Extras Champignons : " + String.format("%.2f", (ingredients.get(i).quantity - 80) * 0.02f) + "€");
            }
        }
        // string adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientsString);
        ingredientsContainer.setAdapter(adapter);
    }


}