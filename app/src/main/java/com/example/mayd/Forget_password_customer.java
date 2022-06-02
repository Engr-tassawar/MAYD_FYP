package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Forget_password_customer extends AppCompatActivity {
    EditText edtEmail;
    Button btnSendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_customer);

        edtEmail=findViewById(R.id.edtEmail);
        btnSendCode=findViewById(R.id.btnSendCode);



    }
}