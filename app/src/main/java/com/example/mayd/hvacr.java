package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class hvacr extends AppCompatActivity {
    TextView tv_gasRefilling,tv_AcNewInstallation,tv_AcReplacement,tv_Refrigerator;
    Button halfHourBtn_Hvacr;
    CheckBox gasRefilling_CheckBox,AcNewInstallation_CheckBox,AcReplacement_CheckBox,Refrigerator_CheckBox;
    Button HvacrPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hvacr);
        tv_gasRefilling=findViewById(R.id.tv_gasRefilling);
        tv_AcNewInstallation=findViewById(R.id.tv_AcNewInstallation);
        tv_AcReplacement=findViewById(R.id.tv_AcReplacement);
        tv_Refrigerator=findViewById(R.id.tv_Refrigerator);
        halfHourBtn_Hvacr=findViewById(R.id.halfHourBtn_Hvacr);
        gasRefilling_CheckBox=findViewById(R.id.gasRefilling_CheckBox);
        AcNewInstallation_CheckBox=findViewById(R.id.AcNewInstallation_CheckBox);
        AcReplacement_CheckBox=findViewById(R.id.AcReplacement_CheckBox);
        Refrigerator_CheckBox=findViewById(R.id.Refrigerator_CheckBox);
        HvacrPackage=findViewById(R.id.HvacrPackage);
        halfHourBtn_Hvacr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hvacr.this, book_your_service.class);
                startActivity(intent);
            }
        });
        HvacrPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hvacr.this, book_your_service.class);
                startActivity(intent);
            }
        });
    }
}