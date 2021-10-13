package com.example.lechant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutBalad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_balad);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("About Balad");
        }
    }
}