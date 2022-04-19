package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class start extends AppCompatActivity {
ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        imgLogo =findViewById(R.id.logo);



        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    Intent intent=new Intent(start.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}