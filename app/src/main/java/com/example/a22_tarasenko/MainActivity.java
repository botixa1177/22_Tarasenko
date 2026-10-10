package com.example.a22_tarasenko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btnNext);
        CheckBox checkBox = findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, "Флажок: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        btnNext.setOnClickListener(v -> goToSecond());

        // Swipe support
        OnSwipeTouchListener swipeListener = new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                goToSecond();
            }
        };

        findViewById(R.id.layout_main).setOnTouchListener(swipeListener);
        findViewById(R.id.scroll_main).setOnTouchListener(swipeListener);
    }

    private void goToSecond() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
