package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import simpleActivity.Forget_password_customer;
import simpleActivity.customerSignUp;
import simpleActivity.home1;
import simpleActivity.customer_login;


public class sign_in_ForCustomer extends AppCompatActivity {
    private static final String TAG = "tag";
    EditText Customer_edtEmailSignIn, Customer_edtPasswordSignIn;
    Button btnSignIn,btnService;
    TextView tvSignUp;
    TextView tvForgotPassword;
    FirebaseUser currentUser;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_customer);

        //getSupportActionBar().hide();
        Customer_edtEmailSignIn = findViewById(R.id.Customer_edtEmailSignIn);
        Customer_edtPasswordSignIn = findViewById(R.id.Customer_edtPasswordSignIn);
        btnSignIn = findViewById(R.id.Customer_btnSignIn_P1);
        btnService = findViewById(R.id.btn_sign_in_ServicesPreference);

        mAuth = FirebaseAuth.getInstance();

/*
        currentUser=mAuth.getCurrentUser();
*/


        tvSignUp = findViewById(R.id.Customer_tvSignUp_SignIn_P1);
        tvForgotPassword = findViewById(R.id.Customer_tvForgotPassword_SignIn);


        btnService.setOnClickListener(view -> {
            Intent intent = new Intent(sign_in_ForCustomer.this, customer_login.class);
            startActivity(intent);
        });


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
        String customerEmail = Customer_edtEmailSignIn.getText().toString();
        String customerPassword = Customer_edtPasswordSignIn.getText().toString();
        if(customerEmail.isEmpty()||customerPassword.isEmpty())
        {
            Toast.makeText(sign_in_ForCustomer.this,
                    "Please enter your mobile or password",Toast.LENGTH_SHORT).show();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(customerEmail).matches())
        {
            Customer_edtEmailSignIn.setError("Please enter valid email");
            Customer_edtEmailSignIn.requestFocus();
            return;
        }
        if (customerPassword.length()<6)
        {
            Customer_edtPasswordSignIn.setError("Minimum password length should be 6 character");
            Customer_edtPasswordSignIn.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(customerEmail,customerPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(sign_in_ForCustomer.this,
                            "Successfully Logged In",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(sign_in_ForCustomer.this, home1.class));
                    finish();
                }
                else {
                    Toast.makeText(sign_in_ForCustomer.this,
                            "Failed to Log in",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
});

        /*btnSignIn.setOnClickListener(new View.OnClickListener() {
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
        });*/


        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in_ForCustomer.this, Forget_password_customer.class);
                startActivity(intent);

            }
        });

    }

   /* boolean validateInput() {
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
    }*/

   /* public static boolean isValidEmail(CharSequence Email) {
        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }*/
  /*  @Override
    protected void onStart() {
        super.onStart();
        if (currentUser!=null){

            Intent intent=new Intent(sign_in_ForCustomer.this, home1.class);
            startActivity(intent);
            onBackPressed();
            finish();
        }
    }*/

}

