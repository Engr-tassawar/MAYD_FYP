package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class signIn extends AppCompatActivity {
EditText edtPhone,edtPassword;
Button btnSignIn;
ImageView imgProfile;
TextView tvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPhone=findViewById(R.id.edtPhone);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignIn=findViewById(R.id.btnSignIn);
        imgProfile=findViewById(R.id.imgProfile);
        tvSignIn=findViewById(R.id.tvSignIn);


    }
}