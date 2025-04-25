package com.example.moodselector;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class SuggestionsActivity extends AppCompatActivity {
    private static final String[] HAPPY_QUOTES = {
            "Happiness is not by chance, but by choice.",
            "The best way to cheer yourself is to try to cheer someone else up.",
            "Let your smile change the world!"
    };
    private static final String[] SAD_QUOTES = {
            "Tough times never last, but tough people do.",
            "Stars can't shine without darkness.",
            "Sadness flies away on the wings of time."
    };
    private static final String[] ANGRY_QUOTES = {
            "For every minute you are angry you lose sixty seconds of happiness.",
            "Speak when you are angry and you will make the best speech you will ever regret.",
            "Anger doesn't solve anything."
    };
    private static final String[] EXCITED_QUOTES = {
            "The excitement of learning separates youth from old age.",
            "Excitement is the more practical synonym for happiness.",
            "Enthusiasm moves the world."
    };
    private static final String[] RELAXED_QUOTES = {
            "Relaxation is the key to a peaceful mind.",
            "Sometimes the most productive thing you can do is relax.",
            "Keep calm and carry on."
    };
    private static final String[] STRESSED_QUOTES = {
            "Keep breathing. You're going to make it.",
            "Stress is caused by being 'here' but wanting to be 'there'.",
            "Do not anticipate trouble or worry about what may never happen."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        TextView tvSuggestionsContent = findViewById(R.id.tvSuggestionsContent);
        String mood = getIntent().getStringExtra("mood");
        StringBuilder sb = new StringBuilder();
        if (mood != null) {
            switch (mood) {
                case "Happy":
                    sb.append("Try spreading your happiness! Call a friend, take a walk, or listen to your favorite music.\n\n");
                    for (String quote : HAPPY_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                case "Sad":
                    sb.append("Take care of yourself. Try journaling, talking to someone you trust, or watching a feel-good movie.\n\n");
                    for (String quote : SAD_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                case "Angry":
                    sb.append("Pause and breathe. Try some deep breathing, go for a run, or listen to calming music.\n\n");
                    for (String quote : ANGRY_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                case "Excited":
                    sb.append("Channel your excitement! Start a new project, dance, or share your joy with others.\n\n");
                    for (String quote : EXCITED_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                case "Relaxed":
                    sb.append("Enjoy your peace. Try meditation, gentle yoga, or simply listen to soothing music.\n\n");
                    for (String quote : RELAXED_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                case "Stressed":
                    sb.append("Pause and care for yourself. Try deep breathing, a short walk, or talk to someone you trust.\n\n");
                    for (String quote : STRESSED_QUOTES) sb.append("\u2022 ").append(quote).append("\n");
                    break;
                default:
                    sb.append("Here you will see suggestions based on your mood.\n\n");
                    sb.append("\u2022 Stay positive!\n\u2022 Take care of yourself.\n\u2022 Every day is a new beginning.");
            }
        }
        tvSuggestionsContent.setText(sb.toString().trim());

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
}
