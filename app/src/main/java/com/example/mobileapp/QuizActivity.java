package com.example.mobileapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView greetingTextView;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    private Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        greetingTextView = findViewById(R.id.greetingTextView);
        radioGroup1 = findViewById(R.id.answers_group_1);
        radioGroup2 = findViewById(R.id.answers_group_2);
        radioGroup3 = findViewById(R.id.answers_group_3);
        radioGroup4 = findViewById(R.id.answers_group_4);
        radioGroup5 = findViewById(R.id.answers_group_5);
        resultButton = findViewById(R.id.next_button);

        // userName from Intent
        String userName = getIntent().getStringExtra("USER_NAME");

        // Displays a greeting to the user
        greetingTextView.setText("Welcome " + userName + " to the Quiz!");

        resultButton.setOnClickListener(v -> {
            // Check if each question has been answered
            if (radioGroup1.getCheckedRadioButtonId() == -1 ||
                    radioGroup2.getCheckedRadioButtonId() == -1 ||
                    radioGroup3.getCheckedRadioButtonId() == -1 ||
                    radioGroup4.getCheckedRadioButtonId() == -1 ||
                    radioGroup5.getCheckedRadioButtonId() == -1) {
                Toast.makeText(QuizActivity.this, "Please answer all questions before proceeding.", Toast.LENGTH_SHORT).show();
                return;
            }

            int scoreA = 0, scoreB = 0, scoreC = 0, scoreD = 0;

            // Calculate points for each questions
            // (Veins)
            int selectedId1 = radioGroup1.getCheckedRadioButtonId();
            if (selectedId1 != -1) {
                RadioButton selectedButton1 = findViewById(selectedId1);
                String answer1 = selectedButton1.getText().toString();
                if (answer1.contains("Veins are light green")) {
                    scoreA++;
                } else if (answer1.contains("Veins are blue with a purple tint")) {
                    scoreB++;
                } else if (answer1.contains("Veins are green with a purple tint")) {
                    scoreC++;
                } else if (answer1.contains("Veins are blue or purple")) {
                    scoreD++;
                }
            }

            // (Sunburn reaction)
            int selectedId2 = radioGroup2.getCheckedRadioButtonId();
            if (selectedId2 != -1) {
                RadioButton selectedButton2 = findViewById(selectedId2);
                String answer2 = selectedButton2.getText().toString();
                if (answer2.contains("Skin easily gets sunburned but recovers quickly and tans after a short time.")) {
                    scoreA++;
                } else if (answer2.contains("Skin easily gets sunburned but takes a long time to tan and becomes darker.")) {
                    scoreB++;
                } else if (answer2.contains("Skin turns red when exposed to the sun but doesn't burn easily.")) {
                    scoreC++;
                } else if (answer2.contains("Skin turns red when exposed to sunlight and burns easily.")) {
                    scoreD++;
                }
            }

            // (Neutral colors)
            int selectedId3 = radioGroup3.getCheckedRadioButtonId();
            if (selectedId3 != -1) {
                RadioButton selectedButton3 = findViewById(selectedId3);
                String answer3 = selectedButton3.getText().toString();
                if (answer3.contains("Your face looks bright and full of life when wearing beige clothing.")) {
                    scoreA++;
                } else if (answer3.contains("There is not much difference, beige or gray clothing looks quite plain.")) {
                    scoreB++;
                } else if (answer3.contains("Gray clothing enhances your complexion and stands out more than beige.")) {
                    scoreC++;
                } else if (answer3.contains("Gray clothing makes your facial features look more defined and prominent.")) {
                    scoreD++;
                }
            }

            //  (Jewelry preferences)
            int selectedId4 = radioGroup4.getCheckedRadioButtonId();
            if (selectedId4 != -1) {
                RadioButton selectedButton4 = findViewById(selectedId4);
                String answer4 = selectedButton4.getText().toString();
                if (answer4.contains("Shiny gold jewelry.")) {
                    scoreA++;
                } else if (answer4.contains("Dull gold, light gold or brass jewelry.")) {
                    scoreB++;
                } else if (answer4.contains("Jewelry in silver or light platinum.")) {
                    scoreC++;
                } else if (answer4.contains("Jewelry in shiny silver or platinum.")) {
                    scoreD++;
                }
            }

            int selectedId5 = radioGroup5.getCheckedRadioButtonId();
            if (selectedId5 != -1) {
                RadioButton selectedButton5 = findViewById(selectedId5);
                String answer5 = selectedButton5.getText().toString();
                if (answer5.contains("Light peachy pink, natural.")) {
                    scoreA++;
                } else if (answer5.contains("Bright coral or red with an orange tint.")) {
                    scoreB++;
                } else if (answer5.contains("Pink-red.")) {
                    scoreC++;
                } else if (answer5.contains("Lotus pink.")) {
                    scoreD++;
                }
            }

            // determine the season
            String season;
            if (scoreA > scoreB && scoreA > scoreC && scoreA > scoreD) {
                season = "Spring";
            } else if (scoreB > scoreA && scoreB > scoreC && scoreB > scoreD) {
                season = "Summer";
            } else if (scoreC > scoreA && scoreC > scoreB && scoreC > scoreD) {
                season = "Autumn";
            } else if (scoreD > scoreA && scoreD > scoreB && scoreD > scoreC) {
                season = "Winter";
            } else {
                //
                season = "Autumn"; // Default season
            }

            // Move to the resultactivity by intent
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("SEASON", season);
            startActivity(intent);
        });
    }
}


