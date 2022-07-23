package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking_details extends AppCompatActivity {
    Button btn_homeBookingDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        btn_homeBookingDetail=findViewById(R.id.btn_homeBookingDetail);
        btn_homeBookingDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_details.this, home1.class);
                startActivity(intent);
            }
        });
    }
}