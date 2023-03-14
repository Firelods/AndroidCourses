package edu.clementlefevre.td3levrai;

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
    private String[] characterNames;
    private String[] characterDescriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.image_view);

        // Obtenir les noms et descriptions de personnages à partir des ressources
        characterNames = getResources().getStringArray(R.array.characters);
        characterDescriptions = getResources().getStringArray(R.array.description);

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