package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password_customer extends AppCompatActivity {
    EditText edtEmail;
    Button btnSend;

    String TAG="tag";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_customer);

        edtEmail = findViewById(R.id.Customer_ForgotPassword_edtEmail);
        btnSend = findViewById(R.id.Customer_ForgotPassword_btnSend);

        mAuth = FirebaseAuth.getInstance();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateData();
                Intent intent=new Intent(Forget_password_customer .this, sign_in_ForCustomer.class);
                startActivity(intent);

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
        String email=edtEmail.getText().toString().trim();
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(Forget_password_customer.this, "Verification Email Send", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(Forget_password_customer.this, sign_in_ForCustomer.class));
                       // finish();
                    }else{
                        Log.d(TAG,  "Error : "+task.getException().getMessage());

                        Toast.makeText(Forget_password_customer.this, "Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG,  "Task Success");


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG,  "onFailure : "+e);
                        Toast.makeText(Forget_password_customer.this, "Failed "+e,Toast.LENGTH_SHORT).show();


                    }
                });
    }
}