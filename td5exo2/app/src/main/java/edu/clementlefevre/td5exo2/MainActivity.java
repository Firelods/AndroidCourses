package edu.clementlefevre.td5exo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ClickableActivity {
    private ListPizza listPizza;

    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView pizzasContainer = findViewById(R.id.pizzas_container);
        listPizza= ListPizza.getInstance();
        pizzaAdapter = new PizzaAdapter(this, listPizza);
        pizzasContainer.setAdapter(pizzaAdapter);

        SeekBar cheeseSeekBar = findViewById(R.id.cheeseSeekBar);
        TextView cheeseTextView = findViewById(R.id.cheeseTextView);
        // set default value to 50g
        cheeseSeekBar.setProgress(50);
        cheeseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cheeseTextView.setText(progress + "g");
                // update quantity of cheese
                for (Pizza pizza : listPizza) {
                    for (Ingredient ingredient : pizza.getIngredients()){
                        if (ingredient.item == Item.FROMAGE) {
                            ingredient.quantity = progress;
                        }
                    }
                }
                updateExtraPrices();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar olivesSeekBar = findViewById(R.id.olivesSeekBar);
        TextView olivesTextView = findViewById(R.id.olivesTextView);
        olivesSeekBar.setMax(12);
        olivesSeekBar.setProgress(3);
        olivesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                olivesTextView.setText(progress + "");
                // update quantity of olives
                for (Pizza pizza : listPizza) {
                    for (Ingredient ingredient : pizza.getIngredients()){
                        if (ingredient.item == Item.OLIVE) {
                            ingredient.quantity = progress;
                        }
                    }
                }
                updateExtraPrices();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar mushroomsSeekBar = findViewById(R.id.mushroomsSeekBar);
        TextView mushroomsTextView = findViewById(R.id.mushroomsTextView);
        mushroomsSeekBar.setMax(200);
        mushroomsSeekBar.setProgress(80);

        mushroomsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mushroomsTextView.setText(progress + "g");
                // update quantity of mushrooms
                // get delta between old and new value
                
                for (Pizza pizza : listPizza) {
                    for (Ingredient ingredient : pizza.getIngredients()){
                        if (ingredient.item == Item.CHAMPIGNON) {
                            ingredient.quantity = progress;
                        }
                    }
                }
                updateExtraPrices();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button buttonOrder = findViewById(R.id.buttonOrder);
        // disable button
        buttonOrder.setEnabled(false);

        buttonOrder.setOnClickListener(v -> {
            // swap to mainActivity2 with the parcelable of the selectionned pizza
            // get the pizza selected
            Pizza pizza = pizzaAdapter.getSelectedPizza();

            // create the intent
            Intent intent = new Intent(this, MainActivity2.class);
            // add the pizza to the intent
            intent.putExtra("pizza", listPizza.indexOf(pizza));
            // start the activity
            startActivity(intent);
        });
    }

    @Override
    public void onClickNom(Pizza item) {
        // alert dialog with the pizza name

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Pizza");
        alertDialog.setMessage("Vous avez sélectionné : "+item.getNom());
        alertDialog.show();
        // make button clickable
        Button buttonOrder = findViewById(R.id.buttonOrder);
        buttonOrder.setEnabled(true);

    }

    private void updateExtraPrices() {
        // for all pizza, update price
        for (Pizza pizza : listPizza) {
            // if cheese > 50, add 5cts
            float extraPrice = 0;
            for (Ingredient ingredient : pizza.getIngredients()) {
                if ((ingredient.item==Item.FROMAGE)&&(ingredient.quantity > 50)) {

                    extraPrice += 0.05f * (ingredient.quantity - 50);
                }
                // if mushroom > 80, add 2cts
                if ((ingredient.item==Item.CHAMPIGNON)&&(ingredient.quantity > 80)) {
                    extraPrice += 0.02f * (ingredient.quantity - 80);
                }
                // if olive > 3, add 20cts
                if ((ingredient.item==Item.OLIVE)&&(ingredient.quantity > 3)) {
                    extraPrice += 0.2f * (ingredient.quantity - 3);
                }
            }
             pizza.setPrice(pizza.getOriginalPrice() + extraPrice);
        }
        pizzaAdapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return this;
    }
}