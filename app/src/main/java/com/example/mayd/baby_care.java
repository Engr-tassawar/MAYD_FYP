package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import simpleActivity.cooker;
import simpleActivity.driver;

public class baby_care extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_care);
        Toolbar toolbar=findViewById(R.id.toolbar_babyCare);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Baby Care Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }
}