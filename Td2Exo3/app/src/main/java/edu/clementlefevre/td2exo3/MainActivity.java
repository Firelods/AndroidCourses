package edu.clementlefevre.td2exo3;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    List<Button> buttons = new ArrayList<Button>();
    Button reapparition ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reapparition = findViewById(R.id.Reapparition);
        AtomicReference<Boolean> allButtonsAreVisible = new AtomicReference<>(true);
        AtomicReference<Long> delay = new AtomicReference<>(1000L);
        Button fondu = findViewById(R.id.buttonFondu);
        fondu.setOnClickListener(v -> {
            reapparition.setBackgroundColor(Color.GREEN);
            fondu.animate().alpha(0).setDuration(delay.get());
        });

        Button retrecissement = findViewById(R.id.buttonRetrecissement);

        retrecissement.setOnClickListener(v -> {
            allButtonsAreVisible.set(false);
            reapparition.setBackgroundColor(Color.GREEN);
            retrecissement.animate().scaleX(0).scaleY(0).setDuration(delay.get()).setInterpolator(new AnticipateInterpolator());
        });
        // add interpolator

        Button sortie = findViewById(R.id.buttonSortie);

        sortie.setOnClickListener(v -> {
            allButtonsAreVisible.set(false);
            reapparition.setBackgroundColor(Color.GREEN);
            sortie.animate().translationX(1000).setDuration(delay.get()).setInterpolator(new AnticipateInterpolator()).withEndAction(() -> {
                sortie.setAlpha(0);
            });
        });

        Button fonduAgrandissement = findViewById(R.id.buttonFonduAgrandissement);

        fonduAgrandissement.setOnClickListener(v -> {
            allButtonsAreVisible.set(false);
            reapparition.setBackgroundColor(Color.GREEN);
            fonduAgrandissement.animate().scaleY(3).scaleX(3).alpha(0).setDuration(delay.get()).setInterpolator(new AnticipateInterpolator());
        });

        Button tvOff = findViewById(R.id.buttonTvOff);

        tvOff.setOnClickListener(v -> {
            allButtonsAreVisible.set(false);
            reapparition.setBackgroundColor(Color.GREEN);
            tvOff.animate().scaleX(4).scaleY((float) 0.2).alpha(0).setDuration(delay.get());
        });

        buttons.add(fondu);
        buttons.add(retrecissement);
        buttons.add(sortie);
        buttons.add(fonduAgrandissement);
        buttons.add(tvOff);


        reapparition.setOnClickListener(v -> {
            allButtonsAreVisible.set(true);
            reapparition.setBackgroundColor(Color.RED);

            // make all buttons to the left to make them appear from lef
            for (Button button : buttons) {
                button.setTranslationX(-1000);
                button.setScaleX(1);
                button.setScaleY(1);
                button.setAlpha(1);
            }
            for (Button button : buttons) {
                button.animate().translationX(0).setDuration(delay.get());
            }
        });

        SeekBar seekBar = findViewById(R.id.slider);
        // make the seekbar range from 100 to 3000
        seekBar.setMax(3000);
        seekBar.setProgress(1000);

        TextView textView= findViewById(R.id.textView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                delay.set((long) progress);
                Float progressFloat = (float) progress;
                progressFloat = progressFloat/3000;
                progressFloat = progressFloat*100;
                // set text to the progress with floor
                textView.setText(Math.floor(progressFloat)+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratio();
    }



    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        // save visibility of buttons
        super.onSaveInstanceState(savedInstanceState);
        for (Button button : buttons) {
            savedInstanceState.putBoolean(button.getId()+"", button.getAlpha() == 1);
        }
        // save background color of reapparition button
        savedInstanceState.putInt("reapparitionColor", reapparition.getBackgroundTintList().getDefaultColor());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        // restore visibility of buttons
        super.onRestoreInstanceState(savedInstanceState);
        for (Button button : buttons) {
            if(savedInstanceState.getBoolean(button.getId()+"")){
                button.setVisibility(View.VISIBLE);
            }else{
                button.setVisibility(View.INVISIBLE);
            }
        }
        // restore color of reapparition button
        Log.d(TAG, "onRestoreInstanceState: "+savedInstanceState.getInt("reapparitionColor"));
        reapparition.setBackgroundColor(savedInstanceState.getInt("reapparitionColor"));
    }

    private void ratio() {
        buttons.forEach(button -> {
            button.setVisibility(View.INVISIBLE);
        });
    }
}