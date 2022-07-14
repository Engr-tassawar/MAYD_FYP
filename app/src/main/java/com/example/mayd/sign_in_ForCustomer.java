package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class sign_in_ForCustomer extends AppCompatActivity {
    private static final String TAG = "tag";
    EditText edtEmail, edtPassword;
    Button btnSignIn;
    TextView tvSignUp;
    TextView tvForgotPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_customer);

        //getSupportActionBar().hide();
        edtEmail = findViewById(R.id.Customer_edtEmailSignIn);
        edtPassword = findViewById(R.id.Customer_edtPasswordSignIn);
        btnSignIn = findViewById(R.id.Customer_btnSignIn_P1);

        mAuth = FirebaseAuth.getInstance();

        tvSignUp = findViewById(R.id.Customer_tvSignUp_SignIn_P1);
        tvForgotPassword = findViewById(R.id.Customer_tvForgotPassword_SignIn);


        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in_ForCustomer.this, customerSignUp.class);
                startActivity(intent);

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validateInput()) {


                    mAuth.signInWithEmailAndPassword(edtEmail.getText().toString().trim(), edtPassword.getText().toString())
                            .addOnCompleteListener(sign_in_ForCustomer.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(sign_in_ForCustomer.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                                        //updateUI(user);
                                        Intent intent = new Intent(sign_in_ForCustomer.this, home1.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(sign_in_ForCustomer.this, "Sign In Failed", Toast.LENGTH_SHORT).show();

                                        // updateUI(null);
                                    }
                                }
                            });
                }


            }
        });


        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in_ForCustomer.this, Forget_password_customer.class);
                startActivity(intent);

            }
        });

    }

    boolean validateInput() {
        String Email = edtEmail.getText().toString().trim();
        String Password = edtPassword.getText().toString();

        if (!isValidEmail(Email)) {
            edtEmail.setError("Email Cannot Be Empty or Invalid");
            return false;
        } else if (Password.equals("")) {
            edtPassword.setError("Password Cannot Be Empty");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(CharSequence Email) {
        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }

}

