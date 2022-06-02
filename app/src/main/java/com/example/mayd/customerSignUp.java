package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class customerSignUp extends AppCompatActivity {
    EditText edtFullName,edtEmail,edtPhone,edtPassword,edtConfirmPassword;
    Button btnSignUp;
    TextView tvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        //For hiding Action Bar
        //getSupportActionBar().hide();

        edtFullName=findViewById(R.id.edtFullNameSignUp);
        edtEmail=findViewById(R.id.edtEmailSignUp);
        edtPassword=findViewById(R.id.edtPasswordSignUp);
        edtConfirmPassword=findViewById(R.id.edtConfirmPasswordSignUp);
        edtPhone=findViewById(R.id.edtPhoneSignUp);

        btnSignUp=findViewById(R.id.btnSignup);
        tvSignIn=findViewById(R.id.tvAlreadyAccountSignUp);

       tvSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(customerSignUp.this, sign_in_ForCustomer.class);
               startActivity(intent);
           }
       });

      btnSignUp.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String FullName=edtFullName.getText().toString().trim();
              String Email=edtEmail.getText().toString().trim();
              String Phone=edtPhone.getText().toString().trim();
              String Password=edtPassword.getText().toString();
              String ConfirmPassword=edtConfirmPassword.getText().toString();

              if (FullName.equals("")){
                  edtFullName.setError("This Place Cannot Be Empty");
              }
          }
      });

}}