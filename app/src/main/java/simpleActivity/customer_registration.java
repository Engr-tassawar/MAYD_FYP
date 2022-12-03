package simpleActivity;

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

import com.example.mayd.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import Model.CustomerUser;

public class customer_registration extends AppCompatActivity {
    EditText customer_edtFullName_SignUp,customer_edtPhone_SignUp, customer_edtPassword_SignUp, customer_edtEmail_SignUp;
    Button customer_btnSignUp;
    TextView tvAlreadyAccount;
    FirebaseAuth mAuth;
     FirebaseDatabase database;
   /* DatabaseReference databaseReference = FirebaseDatabase.getInstance().
            getReferenceFromUrl("https://mayd-535a0-default-rtdb.asia-southeast1.firebasedatabase.app/");*/
   /*String OTP;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_registration);
       mAuth = FirebaseAuth.getInstance();
database=FirebaseDatabase.getInstance();
        customer_edtFullName_SignUp = findViewById(R.id.customer_edtFullName_SignUp);
        customer_edtPhone_SignUp = findViewById(R.id.customer_edtPhone_SignUp);
        customer_edtPassword_SignUp = findViewById(R.id.customer_edtPassword_SignUp);
        customer_edtEmail_SignUp = findViewById(R.id.customer_edtEmail_SignUp);
        customer_btnSignUp = findViewById(R.id.customer_btnSignUp);

        tvAlreadyAccount = findViewById(R.id.customer_tvAlreadyAccountSignIn_SignUp);

        customer_btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String customerFullName = customer_edtFullName_SignUp.getText().toString().trim();
                String customerPhoneNumber = customer_edtPhone_SignUp.getText().toString().trim();
                String customerEmail = customer_edtEmail_SignUp.getText().toString().trim();
                String customerPassword = customer_edtPassword_SignUp.getText().toString().trim();


              if (customerFullName.isEmpty()) {
                  customer_edtFullName_SignUp.setError("Please enter your name");
                  customer_edtFullName_SignUp.requestFocus();
                    return;
                }
                if (customerPhoneNumber.isEmpty()) {
                    customer_edtPhone_SignUp.setError("Please enter your phone number");
                    customer_edtPhone_SignUp.requestFocus();
                    return;
                }
                if (customerEmail.isEmpty()) {
                    customer_edtEmail_SignUp.setError("Please enter your email");
                    customer_edtEmail_SignUp.requestFocus();
                    return;
                }
                if (customerPassword.isEmpty()) {
                    customer_edtPassword_SignUp.setError("Please enter your email");
                    customer_edtPassword_SignUp.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(customerEmail).matches())
                {
                    customer_edtEmail_SignUp.setError("Please enter valid email");
                    customer_edtEmail_SignUp.requestFocus();
                    return;
                }
               if (customerPassword.length()<6)
                {
                    customer_edtPassword_SignUp.setError("Minimum password length should be 6 character");
                    customer_edtPassword_SignUp.requestFocus();
                    return;
                }
                    mAuth.createUserWithEmailAndPassword(customerEmail, customerPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                               CustomerUser customerUser=new CustomerUser(customerFullName,
                                       customerEmail,customerPhoneNumber,customerPassword,"abc");

                                FirebaseDatabase.getInstance().getReference("CustomerUsers")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(customerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {

                                                    Toast.makeText(customer_registration.this,
                                                            "User has been successfully registered", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(customer_registration.this,
                                                            "Failed to register!Try Again", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });/*.addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(serviceProviderSignUp.this,
                                                        "Failed to register", Toast.LENGTH_SHORT).show();
                                            }
                                        });*/

                            } else {
                                Toast.makeText(customer_registration.this,
                                        "Failed to register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
        });

        /*ServiceProvider_btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

       /* ServiceProvider_btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=ServiceProvider_edtEmail_SignUp.getText().toString();
                String Password=ServiceProvider_edtPassword_SignUp.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            User user=new User(ServiceProvider_edtFullName_SignUp.getText().toString(),
                                    ServiceProvider_edtPhone_SignUp.getText().toString(),email,Password);
                       String id =task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);
                            Toast.makeText(serviceProviderSignUp.this,
                                    "User data saved",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(serviceProviderSignUp.this,
                                    "Error",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });*/

       /* ServiceProvider_btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from editText into string variable

                String fullName = ServiceProvider_edtFullName_SignUp.getText().toString();
                String phoneNumber = ServiceProvider_edtPhone_SignUp.getText().toString();
                String password = ServiceProvider_edtPassword_SignUp.getText().toString();
                String confirmPassword = ServiceProvider_edtConfirmPassword_SignUp.getText().toString();

                ///check if user fill all fields before sending data to firebase
                if (fullName.isEmpty() || phoneNumber.isEmpty()
                        || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(serviceProviderSignUp.this,
                            "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                //check if password are matching with each other
                else if (!password.equals(confirmPassword)) {
                    Toast.makeText(serviceProviderSignUp.this,
                            "Password are not matching", Toast.LENGTH_SHORT).show();
                }
                //sending data to firebase realtimedarabase
                //we are using phone number as unique identity of every user
                //so all the other details of user comes under phone number

                else {

                    databaseReference.child("users").child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if phone number is not register before
                            if (snapshot.hasChild(phoneNumber)) {
                                Toast.makeText(serviceProviderSignUp.this,
                                        "Phone number is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                databaseReference.child("users").child(phoneNumber).child("fullname").setValue(fullName);
                                databaseReference.child("users").child(phoneNumber).child("password").setValue(password);
                                Toast.makeText(serviceProviderSignUp.this,
                                        "User register successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });*/

        tvAlreadyAccount.setOnClickListener(view -> {
            Intent intent = new Intent(customer_registration.this, customer_login.class);
            startActivity(intent);
        });

        /*btnSignUp.setOnClickListener(new View.OnClickListener() {
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

                           *//* if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                // Invalid request
                            } else if (e instanceof FirebaseTooManyRequestsException) {
                                // The SMS quota for the project has been exceeded
                            }*//*

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
    }*/

   /* boolean validateInput() {
        return true;
        String FullName = edtFullName.getText().toString().trim();
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
        }
    }*/

    }
}

