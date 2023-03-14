package edu.clementlefevre.td2exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addOne = findViewById(R.id.buttonPlus);
        Button subOne = findViewById(R.id.buttonMoins);
        TextView counter = findViewById(R.id.textView);
        // add reaction to the button
        addOne.setOnClickListener(v -> {
            counter.setText(String.valueOf(Integer.parseInt(counter.getText().toString()) + 1));
        });
        subOne.setOnClickListener(v -> {
            counter.setText(String.valueOf(Integer.parseInt(counter.getText().toString()) - 1));
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        TextView counter = findViewById(R.id.textView);
        savedInstanceState.putString("counter", counter.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        TextView counter = findViewById(R.id.textView);
        counter.setText(savedInstanceState.getString("counter"));
    }


}