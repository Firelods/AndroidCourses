package edu.clementlefevre.tdnote1;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> listHoursButton = new ArrayList<>();
    ArrayList<Button> listMinutesButton = new ArrayList<>();
    ArrayList<Button> listSecondsButton = new ArrayList<>();

    ObjectAnimator rotateAnimation;
    private float currentNeedleAngle=0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        listHoursButton.add(findViewById(R.id.hour0));
        listHoursButton.add(findViewById(R.id.hour1));
        listHoursButton.add(findViewById(R.id.hour2));
        listHoursButton.add(findViewById(R.id.hour3));
        listHoursButton.add(findViewById(R.id.hour4));
        listHoursButton.add(findViewById(R.id.hour5));

        listMinutesButton.add(findViewById(R.id.minute0));
        listMinutesButton.add(findViewById(R.id.minute1));
        listMinutesButton.add(findViewById(R.id.minute2));
        listMinutesButton.add(findViewById(R.id.minute3));
        listMinutesButton.add(findViewById(R.id.minute4));
        listMinutesButton.add(findViewById(R.id.minute5));

        listSecondsButton.add(findViewById(R.id.seconds0));
        listSecondsButton.add(findViewById(R.id.seconds1));
        listSecondsButton.add(findViewById(R.id.seconds2));
        listSecondsButton.add(findViewById(R.id.seconds3));
        listSecondsButton.add(findViewById(R.id.seconds4));
        listSecondsButton.add(findViewById(R.id.seconds5));


        /*On déplace la molette de la seekBar ; sa valeur varie de 0 à 86399

    l'affichage de l'heure change ( on appelle la méthode displayOnTextView(time) )*/
        /*les boutons hour... minute... et second... changent de couleur ( on appelle la méthode displayOnButtons(time) )*/

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displayTime(progress);
//                rotateAnimation.end();
//                findViewById(R.id.pin).setRotation(currentNeedleAngle);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Create an ObjectAnimator to rotate the needle continuously
        ObjectAnimator rotateAnimation = (ObjectAnimator) AnimatorInflater.
                loadAnimator(getApplicationContext(),
                        R.animator.
                                rotation);
        rotateAnimation.setTarget(findViewById(R.id.pin));
        rotateAnimation.addUpdateListener(animation -> {
            this.currentNeedleAngle = (float) animation.getAnimatedValue();
        });
        findViewById(R.id.pin).setPivotX(80f);
        findViewById(R.id.pin).setPivotY(150f);
        rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimation.start();
    }

    private void displayTime(int time) {
        displayOnTextView(time);
        displayOnButtons(time);
//        displayOnNeedle(time);
    }

    private void displayOnButtons(int progress) {
        /* show the binary representation of the time with buttons*/
        int hours = progress / 3600;
        int minutes = (progress % 3600) / 60;
        int seconds = progress % 60;
        String hoursBin = Integer.toBinaryString(hours);
        String[] hoursBinArray = hoursBin.split("");
        String minutesBin = Integer.toBinaryString(minutes);
        String[] minutesBinArray = minutesBin.split("");
        String secondsBin = Integer.toBinaryString(seconds);
        String[] secondsBinArray = secondsBin.split("");


        String[] hoursBinArrayReverse = new String[hoursBinArray.length];
        for (int i = 0; i < hoursBinArray.length; i++) {
            hoursBinArrayReverse[i] = hoursBinArray[hoursBinArray.length - i - 1];
        }
        for (int i = 0; i < hoursBinArrayReverse.length; i++) {
            if (Objects.equals(hoursBinArrayReverse[i], "1")) {
                listHoursButton.get(listHoursButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.red));
            } else {
                listHoursButton.get(listHoursButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.blue));
            }
        }


        String[] minutesBinArrayReverse = new String[minutesBinArray.length];
        for (int i = 0; i < minutesBinArray.length; i++) {
            minutesBinArrayReverse[i] = minutesBinArray[minutesBinArray.length - i - 1];
        }
        for (int i = 0; i < minutesBinArrayReverse.length; i++) {
            if (Objects.equals(minutesBinArrayReverse[i], "1")) {
                listMinutesButton.get(listMinutesButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.red));
            } else {
                listMinutesButton.get(listMinutesButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.blue));
            }
        }

        String[] secondsBinArrayReverse = new String[secondsBinArray.length];
        for (int i = 0; i < secondsBinArray.length; i++) {
            secondsBinArrayReverse[i] = secondsBinArray[secondsBinArray.length - i - 1];
        }
        for (int i = 0; i < secondsBinArrayReverse.length; i++) {
            if (Objects.equals(secondsBinArrayReverse[i], "1")) {
                listSecondsButton.get(listSecondsButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.red));
            } else {
                listSecondsButton.get(listSecondsButton.size() - i - 1).setBackgroundColor(getResources().getColor(R.color.blue));
            }
        }
    }

    private void displayOnTextView(int progress) {
        TextView textView = findViewById(R.id.timer);
        int hours = progress / 3600;
        int minutes = (progress % 3600) / 60;
        int seconds = progress % 60;
        textView.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

}