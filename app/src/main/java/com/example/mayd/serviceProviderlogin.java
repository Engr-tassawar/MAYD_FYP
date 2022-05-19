package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class serviceProviderlogin extends AppCompatActivity {
    Button btnCreate,btnLogin;
    TextView tvDonNot,tvOr,tvAlready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_providerlogin);
        btnCreate=findViewById(R.id.btnCreateAccount);
        btnLogin=findViewById(R.id.btnLogin);
        tvAlready=findViewById(R.id.tvAlreadyAccount);
        tvDonNot=findViewById(R.id.tvDoNotAccount);
        tvOr=findViewById(R.id.tvOR);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(serviceProviderlogin.this,serviceProviderSignUp.class);
                startActivity(intent);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(serviceProviderlogin.this,signIn.class);
                startActivity(intent);

            }
        });
    }
}