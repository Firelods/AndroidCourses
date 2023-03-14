package edu.clementlefevre.exo4td3;

import java.util.ArrayList;

public class ListPizza extends ArrayList<Pizza> {

    public ListPizza(){
        add(new Pizza("Margherita", R.drawable.pizza1, 5.5f));
        add(new Pizza("Reine", R.drawable.pizza2, 6.5f));
        add(new Pizza("4 fromages", R.drawable.pizza3, 7.5f));
        add(new Pizza("Calzone", R.drawable.pizza4, 8.5f));
        add(new Pizza("Napolitaine", R.drawable.pizza5, 9.5f));
        add(new Pizza("Royale", R.drawable.pizza6, 10.5f));
        add(new Pizza("Hawaienne", R.drawable.pizza7, 11.5f));
        add(new Pizza("Bolognaise", R.drawable.pizza8, 12.5f));
        add(new Pizza("Carbonara", R.drawable.pizza9, 13.5f));

    }
}
