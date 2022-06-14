package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class serviceProviderSignUp extends AppCompatActivity {
    EditText edtFullName, edtPhone, edtCNIC, edtPassword, edtConfirmPassword;
    Button btnSignUp;
    TextView tvAlreadyAccount;
    String OTP;

    private FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up);

        mAuth = FirebaseAuth.getInstance();

        edtFullName = findViewById(R.id.ServiceProvider_edtFullName_SignUp);
        edtPhone = findViewById(R.id.ServiceProvider_edtPhone_SignUp);
        edtCNIC = findViewById(R.id.ServiceProvider_edtCNIC_SignUp);
        edtPassword = findViewById(R.id.ServiceProvider_edtPassword_SignUp);
        edtConfirmPassword = findViewById(R.id.ServiceProvider_edtConfirmPassword_SignUp);
        btnSignUp = findViewById(R.id.ServiceProvider_btnSignUp);

        tvAlreadyAccount = findViewById(R.id.ServiceProvider_tvAlreadyAccountSignIn_SignUp);



        tvAlreadyAccount.setOnClickListener(view -> {
            Intent intent = new Intent(serviceProviderSignUp.this, sign_in_for_service_provider.class);
            startActivity(intent);
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()){
                    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                        @Override
                        public void onVerificationCompleted(PhoneAuthCredential credential) {
                            // This callback will be invoked in two situations:
                            // 1 - Instant verification. In some cases the phone number can be instantly
                            //     verified without needing to send or enter a verification code.
                            // 2 - Auto-retrieval. On some devices Google Play services can automatically
                            //     detect the incoming verification SMS and perform verification without
                            //     user action.
                            Log.d("tag", "onVerificationCompleted:" + credential);
                            Toast.makeText(serviceProviderSignUp.this, "VerificationCompleted", Toast.LENGTH_SHORT).show();

                            //  signInWithPhoneAuthCredential(credential);
                        }

                        @Override
                        public void onVerificationFailed(FirebaseException e) {
                            // This callback is invoked in an invalid request for verification is made,
                            // for instance if the the phone number format is not valid.
                            Toast.makeText(serviceProviderSignUp.this, "VerificationFailed"+e, Toast.LENGTH_SHORT).show();
                            Log.d("tag", "onVerificationFailed", e);

                           /* if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                // Invalid request
                            } else if (e instanceof FirebaseTooManyRequestsException) {
                                // The SMS quota for the project has been exceeded
                            }*/

                            // Show a message and update the UI
                        }

                        @Override
                        public void onCodeSent(@NonNull String verificationId,
                                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
                            // The SMS verification code has been sent to the provided phone number, we
                            // now need to ask the user to enter the code and then construct a credential
                            // by combining the code with a verification ID.

                            OTP=verificationId;
                            // Save verification ID and resending token so we can use them later
//                            mVerificationId = verificationId;
//                            mResendToken = token;
                        }
                    };

                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(edtPhone.getText().toString())       // Phone number to verify
                                    .setTimeout(1L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(serviceProviderSignUp.this)                 // Activity (for callback binding)
                                    .setCallbacks(mCallbacks)
                                    .build();

                    PhoneAuthProvider.verifyPhoneNumber(options);
                    Toast.makeText(serviceProviderSignUp.this, "OTP is"+ OTP, Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

    boolean validateInput() {
        return true;
        /*String FullName = edtFullName.getText().toString().trim();
        String Phone = edtPhone.getText().toString().trim();
        String CNIC = edtCNIC.getText().toString().trim();
        String Password = edtPassword.getText().toString();
        String ConfirmPassword = edtConfirmPassword.getText().toString();

        if (FullName.equals("")) {
            edtFullName.setError("Name Cannot Be Empty");
            return false;
        } else if (Phone.equals("")) {
            edtPhone.setError("Phone Cannot Be Empty");
            return false;
        } else if (CNIC.equals("")) {
            edtCNIC.setError("Phone Cannot Be Empty");
            return false;
        } else if (Password.equals("")) {
            edtPassword.setError("Password Cannot Be Empty");
            return false;
        } else if (!ConfirmPassword.equals(Password)) {
            edtConfirmPassword.setError("Password DidNot Match");
            return false;
        } else {
            return true;
        }*/
    }
}