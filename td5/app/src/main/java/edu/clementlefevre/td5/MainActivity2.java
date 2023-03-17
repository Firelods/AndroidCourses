package edu.clementlefevre.td5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = findViewById(R.id.container);

        // get the value of the input
        String value = getIntent().getStringExtra(getString(R.string.VARKEY1));
        // create the adapter
        MyAdapter adapter = new MyAdapter(this, value);
        // set the adapter to the list view
        listView.setAdapter(adapter);
    }


    public Context getContext() {
        return this;
    }
}