package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class forget extends AppCompatActivity {
    TextView forget;
    EditText fullName,cellNum,password1,password2;
    Button code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        password1=findViewById(R.id.password);
        password2=findViewById(R.id.confrm);
        fullName=findViewById(R.id.full);
        cellNum=findViewById(R.id.number);
        code=findViewById(R.id.signButton);


    }
}