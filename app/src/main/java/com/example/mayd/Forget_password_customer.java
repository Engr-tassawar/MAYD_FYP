package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password_customer extends AppCompatActivity {
    EditText edtEmail;
    Button btnSend;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_customer);

        edtEmail = findViewById(R.id.Customer_ForgotPassword_edtEmail);
        btnSend = findViewById(R.id.Customer_ForgotPassword_btnSend);

        mAuth = FirebaseAuth.getInstance();

        /*btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forget_password_customer .this, sign_in_ForCustomer.class);
                startActivity(intent);*/

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateData();
            }
        });

    }

    void ValidateData() {
        String Email = edtEmail.getText().toString().trim();
        if (Email.equals("")) {
            edtEmail.setError("Email Cannot Be Empty");
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            edtEmail.setError("Email Cannot Be Empty");
        }
        else {
            ForgetPassword();
        }
    }

    void ForgetPassword() {
        mAuth.sendPasswordResetEmail(edtEmail.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Forget_password_customer.this, "Verification Email Send", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Forget_password_customer.this, sign_in_ForCustomer.class));
                            finish();
                        }else{
                            Toast.makeText(Forget_password_customer.this, "Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}