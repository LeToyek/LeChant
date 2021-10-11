package com.example.lechant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutClassic extends AppCompatActivity {

    private TextView aboutDescClassical;
    private static final String EXTRA_DESCRIPTION = "extra_description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_classic);

        aboutDescClassical = findViewById(R.id.tv_about_desc_classical);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        aboutDescClassical.setText(description);

    }
}