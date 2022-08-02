package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class driver extends AppCompatActivity {
    TextView tv_hireDriver,tv_chauffeur,tv_driver_cityToCity,tv_driver_withinCity;
    CheckBox hireDriver_CheckBox,chauffeur_CheckBox,driver_cityToCity_CheckBox,driver_withinCity_CheckBox;
    Button driverPackage;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        hireDriver_CheckBox=findViewById(R.id.hireDriver_CheckBox);
        chauffeur_CheckBox=findViewById(R.id.chauffeur_CheckBox);
        driver_cityToCity_CheckBox=findViewById(R.id.driver_cityToCity_CheckBox);
        driver_withinCity_CheckBox=findViewById(R.id.driver_withinCity_CheckBox);

        tv_hireDriver=findViewById(R.id.tv_hireDriver);
        tv_chauffeur=findViewById(R.id.tv_chauffeur);
        tv_driver_cityToCity=findViewById(R.id.tv_driver_cityToCity);
        tv_driver_withinCity=findViewById(R.id.tv_driver_withinCity);

        driverPackage=findViewById(R.id.driverPackage);
        driverPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(driver.this, book_your_service.class);
                startActivity(intent);
            }
        });

    }
}