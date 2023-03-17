package edu.clementlefevre.exo4td3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView pizzasContainer = findViewById(R.id.pizzas_container);
        ListPizza listPizza = new ListPizza();
        /*
        4)  Ecrire une classe PizzaAdapter pour initialiser chaque item et pour gérer      l’évènement  « clik » sur le nom de la pizza

 5) Ecrire la classe MainActivity pour initialiser la listView à travers l’adapter

         */
        PizzaAdapter pizzaAdapter = new PizzaAdapter(this, listPizza);
        pizzasContainer.setAdapter(pizzaAdapter);


    }

    @Override
    public void onClickNom(Pizza item) {
        // alert dialog with the pizza name

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Pizza");
        alertDialog.setMessage(item.getNom());
        alertDialog.show();

    }

    @Override
    public Context getContext() {
        return this;
    }
}