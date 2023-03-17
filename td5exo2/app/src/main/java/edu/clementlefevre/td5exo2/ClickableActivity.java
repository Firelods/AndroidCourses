package edu.clementlefevre.td5exo2;

import android.content.Context;

/**
 * Interface pour écouter les évènements sur le nom d'une personne
 */
public interface ClickableActivity {
    void onClickNom(Pizza item);
    Context getContext();
}
