package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kết nối các view từ layout
        nameEditText = findViewById(R.id.Name);
        startButton = findViewById(R.id.startButton);

        // Thiết lập sự kiện click cho nút Start Quiz
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy tên người dùng từ EditText
                String userName = nameEditText.getText().toString().trim();

                if (userName.isEmpty()){
                    Toast.makeText(MainActivity.this,"Pleas enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    // Chuyển sang QuizActivity và truyền tên người dùng
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("USER_NAME", userName);
                    startActivity(intent);
                }
            }
        });
    }
}