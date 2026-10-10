package com.example.a22_tarasenko;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnPrev = findViewById(R.id.btnPrev);
        Switch switchToggle = findViewById(R.id.switchToggle);

        switchToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Переключатель: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        btnPrev.setOnClickListener(v -> finish());

        // Swipe support
        OnSwipeTouchListener swipeListener = new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeRight() {
                finish();
            }
        };

        findViewById(R.id.layout_third).setOnTouchListener(swipeListener);
        findViewById(R.id.scroll_third).setOnTouchListener(swipeListener);
    }
}
