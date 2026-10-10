package com.example.a22_tarasenko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrev = findViewById(R.id.btnPrev);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            Toast.makeText(this, "Выбран радиокнопка ID: " + checkedId, Toast.LENGTH_SHORT).show();
        });

        btnNext.setOnClickListener(v -> goToThird());
        btnPrev.setOnClickListener(v -> finish());

        // Swipe support
        OnSwipeTouchListener swipeListener = new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                goToThird();
            }

            @Override
            public void onSwipeRight() {
                finish();
            }
        };

        findViewById(R.id.layout_second).setOnTouchListener(swipeListener);
        findViewById(R.id.scroll_second).setOnTouchListener(swipeListener);
    }

    private void goToThird() {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
