package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hbb20.CountryCodePicker;

public class register_number extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText putNumberEdt;
    TextView tvRegister_serviceProvider;
    Button ServiceProvider_getOtp,btnCustomer;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);
        mAuth=FirebaseAuth.getInstance();

        /*String _fullName=getIntent().getStringExtra("fullName");
        String _city=getIntent().getStringExtra("city");
        String _phoneNumber=getIntent().getStringExtra("phoneNumber");*/

        ccp=findViewById(R.id.ccp);
        btnCustomer=findViewById(R.id.btnCustomer);
        tvRegister_serviceProvider=findViewById(R.id.tvRegister_serviceProvider);
        putNumberEdt=findViewById(R.id.putNumberEdt);
        ServiceProvider_getOtp=findViewById(R.id.ServiceProvider_getOtp);
        ccp.registerCarrierNumberEditText(putNumberEdt);

        tvRegister_serviceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_number.this, register_service_provider_number.class);
                startActivity(intent);
            }
        });
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_number.this, sign_in_ForCustomer.class);
                startActivity(intent);
            }
        });
        ServiceProvider_getOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = putNumberEdt.getText().toString();
                if (phone.isEmpty())
                {
                    Toast.makeText(register_number.this,
                            "Please enter your mobile number",Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(register_number.this, manage_otp.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace("",""));
               /* intent.putExtra("fullName",_fullName);
                intent.putExtra("city",_city);
                intent.putExtra("phoneNumber",_phoneNumber);*/
                startActivity(intent);
            }
        });
    }
}