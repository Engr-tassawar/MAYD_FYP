package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sign_in_ForCustomer extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    Button btnSignIn;
    TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_customer);

        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignIn=findViewById(R.id.btnSignIn);

        tvSignUp=findViewById(R.id.tvSignUp);


        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_ForCustomer.this, customerSignUp.class);
                startActivity(intent);

            }
        });

    }}