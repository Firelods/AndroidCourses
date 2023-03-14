package edu.clementlefevre.exo4td3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaAdapter extends BaseAdapter {

    private ListPizza listPizza;
    private LayoutInflater mInflater;  //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private ClickableActivity activity;
    private boolean isClicked = false;


    public PizzaAdapter(ClickableActivity activity, ListPizza items) {
        this.activity = activity;
        this.listPizza = items;
        mInflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return listPizza.size();
    }

    public Object getItem(int position) {
        return listPizza.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = convertView == null ? mInflater.inflate(R.layout.pizza_layout, parent, false) : convertView;
        // on click on pizza, make the pizza name bigger and orange

        //(2) : Récupération des TextView de notre layout
        ImageView pizzaImage = layoutItem.findViewById(R.id.pizza_image);
        TextView pizzaName = layoutItem.findViewById(R.id.pizza_text);
        TextView pizzaPrice = layoutItem.findViewById(R.id.pizza_price);
        layoutItem.setOnClickListener(v -> {
            if (!isClicked){
                pizzaName.setTextSize(30);
                pizzaName.setTextColor(activity.getContext().getResources().getColor(R.color.orange));
            }
            isClicked = true;
            activity.onClickNom(listPizza.get(position));
        });
        //(3) : Renseignement des valeurs
        pizzaImage.setImageResource(listPizza.get(position).getImage());

        pizzaPrice.setText(listPizza.get(position).getPrice() + "€");
        // on change of price, change the textView
        if (listPizza.get(position).getPrice() > 9) {
            pizzaPrice.setTextColor(activity.getContext().getResources().getColor(R.color.red));
        }
        pizzaName.setText(listPizza.get(position).getNom());

        //(4) Changement de la couleur du fond de notre item

//        layoutItem.setOnClickListener(v -> activity.onClickNom(listPizza.get(position)));

        return layoutItem; //On retourne l'item créé.
    }


}
