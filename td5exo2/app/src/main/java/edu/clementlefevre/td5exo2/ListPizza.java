package edu.clementlefevre.td5exo2;

import java.util.ArrayList;

public class ListPizza extends ArrayList<Pizza> {

    public ListPizza(){
        ArrayList<Item> listIngredient1 = new ArrayList<>();
        listIngredient1.add(new Item(Item.TOMATE,20,"dl"));
        listIngredient1.add(new Item(Item.POIVRON,1,""));
        listIngredient1.add(new Item(Item.CHORIZO,50f,"g"));
        listIngredient1.add(new Item(Item.MOZARELLA,50,"g"));

        ArrayList<Item> listIngredient2 = new ArrayList<>();
        listIngredient2.add(new Item(Item.TOMATE,20,"dl"));
        listIngredient2.add(new Item(Item.OIGNON,2,""));
        listIngredient2.add(new Item(Item.POULET,200,"g"));
        listIngredient2.add(new Item(Item.EMMENTAL,50,"g"));

        ArrayList<Item> listIngredient3 = new ArrayList<>();
        listIngredient3.add(new Item(Item.TOMATE,25,"dl"));
        listIngredient3.add(new Item(Item.EMMENTAL,50,"g"));

        ArrayList<Item> listIngredient4 = new ArrayList<>();
        listIngredient4.add(new Item(Item.TOMATE,20,"dl"));
        listIngredient4.add(new Item(Item.CHAMPIGNON,80,"g"));
        listIngredient4.add(new Item(Item.JAMBON,150,"g"));
        listIngredient4.add(new Item(Item.EMMENTAL,50,"g"));
        listIngredient4.add(new Item(Item.OLIVE,3,""));

        ArrayList<Item> listIngredient5 = new ArrayList<>();
        listIngredient5.add(new Item(Item.TOMATE,20,"dl"));
        listIngredient5.add(new Item(Item.CHAMPIGNON,80,"g"));
        listIngredient5.add(new Item(Item.JAMBON,150,"g"));
        listIngredient5.add(new Item(Item.EMMENTAL,50,"g"));

        ArrayList<Item> listIngredient6 = new ArrayList<>();
        listIngredient6.add(new Item(Item.TOMATE,20,"dl"));
        listIngredient6.add(new Item(Item.CHAMPIGNON,80,"g"));
        listIngredient6.add(new Item(Item.BLEU,50,"g"));
        listIngredient6.add(new Item(Item.OLIVE,3,""));
        listIngredient6.add(new Item(Item.GOUDA,50,"g"));
        listIngredient6.add(new Item(Item.EMMENTAL,50,"g"));


        add(new Pizza("Fromage", 4, R.drawable.pizza3, listIngredient4));
        add(new Pizza("Chorizo", 9, R.drawable.pizza2, listIngredient1));
        add(new Pizza("Poulet", 5, R.drawable.pizza1, listIngredient2));
        add(new Pizza("Royale", 7, R.drawable.pizza7, listIngredient6));
        add(new Pizza("Calzone", 2, R.drawable.pizza4, listIngredient4));
        add(new Pizza("Regina", 8, R.drawable.pizza5, listIngredient6));
        add(new Pizza("indienne", 2, R.drawable.pizza6, listIngredient5));
        add(new Pizza("Speciale", 2, R.drawable.pizza8, listIngredient3));
        add(new Pizza("Végetarienne",7, R.drawable.pizza9, listIngredient3));
    }
}
