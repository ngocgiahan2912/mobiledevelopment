package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private ImageView colorImage;
    private TextView detailText;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        resultText = findViewById(R.id.result_text);
        colorImage = findViewById(R.id.season_image);
        detailText = findViewById(R.id.detail_text);
        listView = findViewById(R.id.list_view);
        Button backButton = findViewById(R.id.back_button);

        // result from Intent
        String season = getIntent().getStringExtra("SEASON");


        resultText.setText("Your personal color is " + season);

        String[] options = {"Outfit", "Makeup"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (season != null) {
                switch (season) {
                    case "Spring":
                        if (position == 0) {
                            detailText.setText("Outfit: Light, airy fabrics in pastel colors. Floral prints and soft textures are ideal. Think feminine and romantic.");
                        } else if (position == 1) {
                            detailText.setText("Makeup: Soft, pastel tones like peach, pink, and lavender. Opt for sheer textures and natural finishes. Avoid harsh lines and dark colors.");
                        }
                        break;
                    case "Summer":
                        if (position == 0) {
                            detailText.setText("Outfit: Soft, drapey fabrics in muted colors. Jewel tones and pastels can also look lovely. Think elegant and understated.");
                        } else if (position == 1) {
                            detailText.setText("Makeup: Cool-toned colors like silver, blue, and purple. Soft, muted shades work best. Opt for matte finishes and avoid heavy makeup.");
                        }
                        break;
                    case "Autumn":
                        if (position == 0) {
                            detailText.setText("Outfit: Warm, textured fabrics in rich colors. Think cozy and comfortable. Animal prints and chunky knits are great options.");
                        } else if (position == 1) {
                            detailText.setText("Makeup: Warm, earthy tones like bronze, copper, and gold. Deep, rich colors are flattering. Opt for matte or satin finishes.");
                        }
                        break;
                    case "Winter":
                        if (position == 0) {
                            detailText.setText("Outfit: Clean lines and bold colors. Black, white, and bright jewel tones are ideal. Think chic and sophisticated.");
                        } else if (position == 1) {
                            detailText.setText("Makeup: Bold, dramatic colors like black, white, and red. Opt for matte finishes and sharp lines.");
                        }
                        break;
                }
            }
        });


        if (season != null) {
            switch (season) {
                case "Spring":
                    colorImage.setImageResource(R.drawable.spring);
                    break;
                case "Summer":
                    colorImage.setImageResource(R.drawable.summer);
                    break;
                case "Autumn":
                    colorImage.setImageResource(R.drawable.autumn);
                    break;
                case "Winter":
                    colorImage.setImageResource(R.drawable.winter);
                    break;
            }
        }

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
