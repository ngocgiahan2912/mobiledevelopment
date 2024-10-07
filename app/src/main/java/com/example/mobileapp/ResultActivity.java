package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        resultTextView = findViewById(R.id.result_text_view);

        // Lấy kết quả từ Intent
        String season = getIntent().getStringExtra("SEASON");

        // Hiển thị kết quả
        resultTextView.setText("Your personal color is " + season);

    }
}
