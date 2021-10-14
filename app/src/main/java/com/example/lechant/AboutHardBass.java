package com.example.lechant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutHardBass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_hard_bass);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("About");
        }
    }
}