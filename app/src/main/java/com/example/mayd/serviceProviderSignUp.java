package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class serviceProviderSignUp extends AppCompatActivity {
EditText edtFullName,edtPhone,edtCNIC,edtPassword;
Button btnPermanentAddress;
TextView tvHeading,tvAlreadyAccount;
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
        tvAlreadyAccount=findViewById(R.id.tvAlreadyAccount);

        tvAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(serviceProviderSignUp.this, sign_in_for_service_provider.class);
                startActivity(intent);
            }
        });


    }
}