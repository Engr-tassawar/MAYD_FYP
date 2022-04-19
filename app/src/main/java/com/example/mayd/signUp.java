package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class signUp extends AppCompatActivity {
    Button sign;
    TextView forget,create,account;

    EditText firstName,lastName,fullName,cellNum,password1,password2;
    RadioButton box1,box2;
    RadioGroup rdbGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        account=findViewById(R.id.Account);
        sign=findViewById(R.id.signButton);
        box1=findViewById(R.id.male);
        box2=findViewById(R.id.female);
        firstName=findViewById(R.id.first);
        lastName=findViewById(R.id.last);
        fullName=findViewById(R.id.full);
        cellNum=findViewById(R.id.number);

        password1=findViewById(R.id.password);
        password2=findViewById(R.id.confrm);
    }
}