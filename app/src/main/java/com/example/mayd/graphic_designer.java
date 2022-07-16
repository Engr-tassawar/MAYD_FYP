package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class graphic_designer extends AppCompatActivity {
    TextView tv_logoDesign,tv_monthlyPost;
    Button halfHourBtn_Graphic;
    CheckBox logoDesign_CheckBox,monthlyPost_CheckBox;
    Button graphicPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_designer);

        halfHourBtn_Graphic=findViewById(R.id.halfHourBtn_Graphic);
        tv_logoDesign=findViewById(R.id.tv_logoDesign);
        tv_monthlyPost=findViewById(R.id.tv_monthlyPost);
        logoDesign_CheckBox=findViewById(R.id.logoDesign_CheckBox);
        monthlyPost_CheckBox=findViewById(R.id.monthlyPost_CheckBox);
        graphicPackage=findViewById(R.id.graphicPackage);

        halfHourBtn_Graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(graphic_designer.this, book_your_service.class);
                startActivity(intent);
            }
        });
        graphicPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(graphic_designer.this, book_your_service.class);
                startActivity(intent);
            }
        });
    }
}