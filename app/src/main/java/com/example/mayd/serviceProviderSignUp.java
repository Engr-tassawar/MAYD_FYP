package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class serviceProviderSignUp extends AppCompatActivity {
EditText edtFullName,edtPhone,edtCNIC,edtPassword;
Button btnPermanentAddress;
TextView tvAlreadyAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up);
        edtFullName=findViewById(R.id.ServiceProvider_edtFullName_SignUp);
        edtPhone=findViewById(R.id.ServiceProvider_edtPhone_SignUp);
        edtCNIC=findViewById(R.id.ServiceProvider_edtCNIC_SignUp);
        edtPassword=findViewById(R.id.ServiceProvider_edtPassword_SignUp);
        btnPermanentAddress=findViewById(R.id.ServiceProvider_btnSelectAddress_SignUp);

        tvAlreadyAccount=findViewById(R.id.ServiceProvider_tvAlreadyAccountSignIn_SignUp);

        tvAlreadyAccount.setOnClickListener(view -> {
            Intent intent=new Intent(serviceProviderSignUp.this, sign_in_for_service_provider.class);
            startActivity(intent);
        });


    }
}