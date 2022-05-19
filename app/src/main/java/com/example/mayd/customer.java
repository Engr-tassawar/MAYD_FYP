package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customer extends AppCompatActivity {
Button btnCustomer,btnService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        btnCustomer=findViewById(R.id.btnCustomer);
        btnService=findViewById(R.id.btnServices);
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(customer.this,Login.class);
                startActivity(intent);

            }
        });
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(customer.this,serviceProviderlogin.class);
                startActivity(intent);

            }
        });

    }
}