package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class customerSignUp extends AppCompatActivity {
    EditText edtFullName,edtEmail,edtPhone,edtPassword;
    Button btnSignUp;
    TextView tvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        //For hiding Action Bar
        //getSupportActionBar().hide();

        edtFullName=findViewById(R.id.edtFullName);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtPhone=findViewById(R.id.edtPhone);

        btnSignUp=findViewById(R.id.btnSignup);
        tvSignIn=findViewById(R.id.tvAlreadyAccount);

       tvSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(customerSignUp.this, sign_in_ForCustomer.class);
               startActivity(intent);
           }
       });

}}