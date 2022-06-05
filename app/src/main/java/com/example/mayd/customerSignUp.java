package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class customerSignUp extends AppCompatActivity {
    private static final String TAG = "tag";
    EditText edtFullName, edtEmail, edtPhone, edtPassword, edtConfirmPassword;
    Button btnSignUp;
    TextView tvSignIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        //For hiding Action Bar
        //getSupportActionBar().hide();


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        edtFullName = findViewById(R.id.Customer_edtFullNameSignUp);
        edtEmail = findViewById(R.id.Customer_edtEmailSignUp);
        edtPhone = findViewById(R.id.Customer_edtPhoneSignUp);
        edtPassword = findViewById(R.id.Customer_edtPasswordSignUp);
        edtConfirmPassword = findViewById(R.id.Customer_edtConfirmPasswordSignUp);

        btnSignUp = findViewById(R.id.Customer_btnSignup_P2);
        tvSignIn = findViewById(R.id.tvAlreadyAccountSignUp_P2);

        tvSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(customerSignUp.this, sign_in_ForCustomer.class);
            startActivity(intent);
        });

        btnSignUp.setOnClickListener(view -> {

            if(validateInput()){
                //Send data in database
                mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(customerSignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                  //  updateUI(null);
                                }
                            }
                        });
            }
        });
    }

    boolean validateInput()
    {
        String FullName = edtFullName.getText().toString().trim();
        String Email = edtEmail.getText().toString().trim();
        String Phone = edtPhone.getText().toString().trim();
        String Password = edtPassword.getText().toString();
        String ConfirmPassword = edtConfirmPassword.getText().toString();

        if (FullName.equals("")) {
            edtFullName.setError("Name Cannot Be Empty");
            return false;
        }
        else if (!isValidEmail(Email)) {
            edtEmail.setError("Email Cannot Be Empty or Invalid");
            return false;
        }
        else if (Phone.equals("")) {
            edtPhone.setError("Phone Cannot Be Empty");
            return false;
        }
        else if (Password.equals("")) {
            edtPassword.setError("Password Cannot Be Empty");
            return false;
        }
        else if (!ConfirmPassword.equals(Password)) {
            edtConfirmPassword.setError("Password DidNot Match");
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean isValidEmail(CharSequence Email) {
        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }
}