package edu.clementlefevre.td5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            // test if the value of the EditText is a number

            if (editText.getText().toString().equals("")) {
                Toast.makeText(this, "Saisir un nombre SVP", Toast.LENGTH_SHORT).show();
            }
            else{
                // send the input value to the second activity
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra(getString(R.string.VARKEY1), editText.getText().toString());
                startActivity(intent);

            }
        });
    }
}