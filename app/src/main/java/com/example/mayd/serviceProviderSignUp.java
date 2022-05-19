package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class serviceProviderSignUp extends AppCompatActivity {
EditText edtFullName,edtPhone,edtCNIC,edtPassword;
Button btnPermanentAddress;
TextView tvHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up);
        edtFullName=findViewById(R.id.edtFullName);
        edtCNIC=findViewById(R.id.edtCNIC);
        edtPassword=findViewById(R.id.edtPassword);
        edtPhone=findViewById(R.id.edtPhone);
        tvHeading=findViewById(R.id.tvHeading);
        btnPermanentAddress=findViewById(R.id.btnSelectAddress);

    }
}