package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class register_service_provider_number extends AppCompatActivity {
EditText ServiceProvider_edtFullName_register,ServiceProvider_edtCityName_register;
CountryCodePicker ccpForReg;
    Button ServiceProvider_btnRegister;
    EditText ForRegPutNumberEdt;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service_provider_number);

        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        ServiceProvider_edtFullName_register=findViewById(R.id.ServiceProvider_edtFullName_register);
        ccpForReg=findViewById(R.id.ccpForReg);
        ServiceProvider_btnRegister=findViewById(R.id.ServiceProvider_btnRegister);
        ForRegPutNumberEdt=findViewById(R.id.ForRegPutNumberEdt);
        ServiceProvider_edtCityName_register=findViewById(R.id.ServiceProvider_edtCityName_register);

        ccpForReg.registerCarrierNumberEditText(ForRegPutNumberEdt);

        ServiceProvider_btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String fullName = ServiceProvider_edtFullName_register.getText().toString().trim();
                String phoneNumber = ForRegPutNumberEdt.getText().toString().trim();
                String city = ServiceProvider_edtCityName_register.getText().toString().trim();
                if (fullName.isEmpty()) {
                    ServiceProvider_edtFullName_register.setError("Please enter your name");
                    ServiceProvider_edtFullName_register.requestFocus();
                    return;
                }
                if (phoneNumber.isEmpty()) {
                    ForRegPutNumberEdt.setError("Please enter your phone number");
                    ForRegPutNumberEdt.requestFocus();
                    return;
                }
                if (city.isEmpty()) {
                    ServiceProvider_edtCityName_register.setError("Please enter your phone number");
                    ServiceProvider_edtCityName_register.requestFocus();
                    return;
                }
                /*reference=database.getReference("Users");*/
/*
                User user=new User(fullName,city,phoneNumber);
*/
                /*reference.child(phoneNumber).setValue(user);*/

                Intent intent = new Intent(register_service_provider_number.this, manage_otp.class);
                intent.putExtra("mobile",ccpForReg.getFullNumberWithPlus().replace("",""));
                startActivity(intent);
                /*mAuth.signInWithEmailAndPassword(phoneNumber,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            User user = new User(fullName, phoneNumber);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Intent intent = new Intent(register_service_provider_number.this, manage_otp.class);
                                                intent.putExtra("mobile",ccpForReg.getFullNumberWithPlus().replace("",""));
                                                startActivity(intent);
                                            }
                                            else {
                                                Toast.makeText(register_service_provider_number.this,
                                                        "Failed to register!Try Again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(register_service_provider_number.this,
                                                    "Failed to register", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    }
                });*/
            }
        });

    }
}