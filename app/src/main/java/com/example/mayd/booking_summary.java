package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking_summary extends AppCompatActivity {
    Button btn_confirmBookSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summary);
        btn_confirmBookSummary=findViewById(R.id.btn_confirmBookSummary);
        btn_confirmBookSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_summary.this, booking_details.class);
                startActivity(intent);
            }
        });
    }
}