package edu.clementlefevre.exo2td3;

import java.util.ArrayList;

public class Personnages extends ArrayList<Personnage> {

    public Personnages(){
        add(new Personnage("amidala", "Femme politique dans la prélogie (épisodes I, II et III) de Star Wars. Elle est interprétée par Natalie Portman", R.mipmap.amidala));
        add(new Personnage("blue","Dévaronienne qui dirige une petite cellule de Partisans sous l\\'Ère Impériale", R.mipmap.blue));
        add(new Personnage("c3po","Droïde protocolaire de série 3PO en armature dorée", R.mipmap.c3po));
        add(new Personnage("calrissian","Contrebandier aventureux qui devient par coup de chance baron administrateur de la Cité des Nuages de Bespin", R.mipmap.calrissian));
    }
}
