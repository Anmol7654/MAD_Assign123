package com.example.moodselector;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "MoodPrefs";
    private static final String HAPPY_INDEX = "happy_index";
    private static final String SAD_INDEX = "sad_index";
    private static final String ANGRY_INDEX = "angry_index";
    private static final String EXCITED_INDEX = "excited_index";
    private static final String RELAXED_INDEX = "relaxed_index";
    private static final String STRESSED_INDEX = "stressed_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHappy = findViewById(R.id.btnHappy);
        Button btnSad = findViewById(R.id.btnSad);
        Button btnAngry = findViewById(R.id.btnAngry);
        Button btnMoodSuggestions = findViewById(R.id.btnMoodSuggestions);
        Button btnExcited = findViewById(R.id.btnExcited);
        Button btnRelaxed = findViewById(R.id.btnRelaxed);
        Button btnStressed = findViewById(R.id.btnStressed);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(HAPPY_INDEX, 3);
                openMoodDisplay("Happy", idx);
            }
        });

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(SAD_INDEX, 3);
                openMoodDisplay("Sad", idx);
            }
        });

        btnAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(ANGRY_INDEX, 3);
                openMoodDisplay("Angry", idx);
            }
        });

        btnExcited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(EXCITED_INDEX, 3);
                openMoodDisplay("Excited", idx);
            }
        });

        btnRelaxed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(RELAXED_INDEX, 3);
                openMoodDisplay("Relaxed", idx);
            }
        });

        btnStressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = getAndIncrementIndex(STRESSED_INDEX, 3);
                openMoodDisplay("Stressed", idx);
            }
        });

        btnMoodSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuggestionsActivity.class);

                intent.putExtra("mood", "");
                startActivity(intent);
            }
        });
    }

    private int getAndIncrementIndex(String key, int max) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int idx = prefs.getInt(key, 0);
        int nextIdx = (idx + 1) % max;
        prefs.edit().putInt(key, nextIdx).apply();
        return idx;
    }

    private void openMoodDisplay(String mood, int messageIndex) {
        Intent intent = new Intent(MainActivity.this, MoodDisplayActivity.class);
        intent.putExtra("mood", mood);
        intent.putExtra("messageIndex", messageIndex);
        startActivity(intent);
    }
}
