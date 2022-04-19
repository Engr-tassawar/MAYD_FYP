package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView2, textView3;
            TextView CrtNew,forget;
            ImageView imgBike;

    EditText email,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button2);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText);
        CrtNew=findViewById(R.id.textView3);
        forget =findViewById(R.id.textView2);
        imgBike=findViewById(R.id.logo);


        CrtNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signUp.class);
                startActivity(intent);


            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,forget.class);
                startActivity(intent);


            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,home1.class);
                startActivity(intent);


            }
        });


    }


}