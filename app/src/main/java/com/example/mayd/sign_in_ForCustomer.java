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
    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_customer);

        edtEmail=findViewById(R.id.Customer_edtEmailSignIn);
        edtPassword=findViewById(R.id.Customer_edtPasswordSignIn);
        btnSignIn=findViewById(R.id.Customer_btnSignIn_P1);

        tvSignUp=findViewById(R.id.Customer_tvSignUp_SignIn_P1);
        tvForgotPassword=findViewById(R.id.Customer_tvForgotPassword_SignIn);


        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_ForCustomer.this, customerSignUp.class);
                startActivity(intent);

            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_ForCustomer.this, Forget_password_customer.class);
                startActivity(intent);

            }
        });

    }}