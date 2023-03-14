package edu.clementlefevre.exo2td3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ImageView imageView;
    private String[] characterNames= new String[4];
    private String[] characterDescriptions= new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.image_view);

        // Obtenir les noms et descriptions de personnages à partir des ressources
        Personnages personnages = new Personnages();
        for (int i = 0; i < personnages.size(); i++) {
            characterNames[i] = personnages.get(i).getNom();
            characterDescriptions[i] = personnages.get(i).getDescription();
        }

        // Créer un ArrayAdapter pour le Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, characterNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Ajouter un écouteur de sélection de Spinner
        spinner.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
// Afficher l'image et la description du personnage sélectionné
        int imageResource = getResources().getIdentifier(characterNames[i], "mipmap", getPackageName());
        imageView.setImageResource(imageResource);
        TextView textView = findViewById(R.id.text_view);
        textView.setText(characterDescriptions[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Ne rien faire si aucun élément n'est sélectionné
    }

}