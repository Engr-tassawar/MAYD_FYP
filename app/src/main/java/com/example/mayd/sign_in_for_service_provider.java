package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class sign_in_for_service_provider extends AppCompatActivity {
EditText edtPhone;
Button btnSendCode;
TextView tvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_sevice_provider);
        //getSupportActionBar().hide();
        edtPhone=findViewById(R.id.Service_Provider_edtPhone_SignIn);
        btnSendCode=findViewById(R.id.Service_Provider_btnSendCode_SignIn);
        tvSignUp=findViewById(R.id.Service_Provider_tvSignUp_SignIn_P1);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_for_service_provider.this, serviceProviderSignUp.class);
                startActivity(intent);
            }
        });



    }
}