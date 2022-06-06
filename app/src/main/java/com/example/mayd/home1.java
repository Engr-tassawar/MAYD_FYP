package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class home1 extends AppCompatActivity {
Button btnSign;
ImageView imgElectric,imgPlum,imgElder,imgBaby,imgCook,imgDrive;
TextView tvElectric,tvPlum,tvElder,tvBaby,tvCook,tvDrive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_home1);

        imgElectric=findViewById(R.id.imgElectric);
        imgPlum=findViewById(R.id.imgPlum);
        imgElder=findViewById(R.id.imgElder);
        imgBaby=findViewById(R.id.imgBaby);
        imgCook=findViewById(R.id.imgCook);
        imgDrive=findViewById(R.id.imgDrive);
        tvElectric=findViewById(R.id.tvElectric);
        tvPlum=findViewById(R.id.tvPlum);
        tvElder=findViewById(R.id.tvElder);
        tvBaby=findViewById(R.id.tvBaby);
        tvCook=findViewById(R.id.tvCook);
        tvDrive=findViewById(R.id.tvDrive);
        btnSign=findViewById(R.id.btnSign);

    }
}
