package com.example.moodselector;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MoodDisplayActivity extends AppCompatActivity {
    private static final String[] HAPPY_MESSAGES = {
            "Keep smiling, the world is beautiful!",
            "Happiness looks gorgeous on you!",
            "Spread your joy everywhere you go!",
            "Your positive vibes are contagious!",
            "Enjoy every moment of your happiness!"
    };
    private static final String[] SAD_MESSAGES = {
            "It's okay to feel sad sometimes. Brighter days are ahead!",
            "Sending you a virtual hug!",
            "Remember, after rain comes the rainbow.",
            "You are stronger than you think.",
            "Take a deep breath. Better moments are coming!"
    };
    private static final String[] ANGRY_MESSAGES = {
            "Take a moment to breathe. You got this!",
            "Anger is just one letter short of danger. Stay calm!",
            "Let it go, and let peace in.",
            "Channel your energy into something positive!",
            "A calm mind brings inner strength."
    };
    private static final String[] EXCITED_MESSAGES = {
            "Channel your excitement into something creative!",
            "Share your excitement with a friend!",
            "Use your energy to try something new today!"
    };
    private static final String[] RELAXED_MESSAGES = {
            "Enjoy the calm—maybe meditate or listen to soft music.",
            "Perfect time for a book or a gentle walk.",
            "Let yourself recharge and savor the peace."
    };
    private static final String[] STRESSED_MESSAGES = {
            "Take a deep breath and give yourself a break.",
            "Try to step outside or stretch for a few minutes.",
            "Remember, it's okay to ask for help when overwhelmed."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_display);

        TextView tvEmoji = findViewById(R.id.tvEmoji);
        TextView tvMessage = findViewById(R.id.tvMessage);
        TextView tvExtraMessage = findViewById(R.id.tvExtraMessage);
        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnMoodSuggestions = findViewById(R.id.btnMoodSuggestions);

        String mood = getIntent().getStringExtra("mood");
        int messageIndex = getIntent().getIntExtra("messageIndex", 0);
        if (mood != null) {
            switch (mood) {
                case "Happy":
                    tvEmoji.setText("\uD83D\uDE00"); // 😀
                    tvMessage.setText("You're feeling happy!");
                    tvExtraMessage.setText(HAPPY_MESSAGES[messageIndex % HAPPY_MESSAGES.length]);
                    break;
                case "Sad":
                    tvEmoji.setText("\uD83D\uDE1E"); // 😞
                    tvMessage.setText("You're feeling sad.");
                    tvExtraMessage.setText(SAD_MESSAGES[messageIndex % SAD_MESSAGES.length]);
                    break;
                case "Angry":
                    tvEmoji.setText("\uD83D\uDE21"); // 😡
                    tvMessage.setText("You're feeling angry.");
                    tvExtraMessage.setText(ANGRY_MESSAGES[messageIndex % ANGRY_MESSAGES.length]);
                    break;
                case "Excited":
                    tvEmoji.setText("\uD83D\uDE04"); // 😄
                    tvMessage.setText("You're feeling excited!");
                    tvExtraMessage.setText(EXCITED_MESSAGES[messageIndex % EXCITED_MESSAGES.length]);
                    break;
                case "Relaxed":
                    tvEmoji.setText("\uD83D\uDE0C"); // 😌
                    tvMessage.setText("You're feeling relaxed.");
                    tvExtraMessage.setText(RELAXED_MESSAGES[messageIndex % RELAXED_MESSAGES.length]);
                    break;
                case "Stressed":
                    tvEmoji.setText("\uD83D\uDE2B"); // 😫
                    tvMessage.setText("You're feeling stressed.");
                    tvExtraMessage.setText(STRESSED_MESSAGES[messageIndex % STRESSED_MESSAGES.length]);
                    break;
                default:
                    tvEmoji.setText("");
                    tvMessage.setText("");
                    tvExtraMessage.setText("");
            }
        }

        btnBack.setOnClickListener(v -> finish());

        btnMoodSuggestions.setOnClickListener(v -> {
            Intent intent = new Intent(MoodDisplayActivity.this, SuggestionsActivity.class);
            intent.putExtra("mood", mood);
            startActivity(intent);
        });
    }
}
