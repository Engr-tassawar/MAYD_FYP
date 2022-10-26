package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class serviceProviderSignUp extends AppCompatActivity {
    EditText ServiceProvider_edtFullName_SignUp, ServiceProvider_edtPhone_SignUp, ServiceProvider_edtPassword_SignUp, ServiceProvider_edtConfirmPassword_SignUp;
    Button ServiceProvider_btnSignUp;
    TextView tvAlreadyAccount;
     /*FirebaseAuth mAuth;
    FirebaseDatabase database;*/
     DatabaseReference databaseReference= FirebaseDatabase.getInstance().
            getReferenceFromUrl("https://mayd-535a0-default-rtdb.asia-southeast1.firebasedatabase.app/");
   /*String OTP;

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up);


        ServiceProvider_edtFullName_SignUp = findViewById(R.id.ServiceProvider_edtFullName_SignUp);
        ServiceProvider_edtPhone_SignUp = findViewById(R.id.ServiceProvider_edtPhone_SignUp);
        ServiceProvider_edtConfirmPassword_SignUp = findViewById(R.id.ServiceProvider_confirmPassword_SignUp);
        ServiceProvider_edtPassword_SignUp = findViewById(R.id.ServiceProvider_edtPassword_SignUp);
        ServiceProvider_btnSignUp = findViewById(R.id.ServiceProvider_btnSignUp);

        tvAlreadyAccount = findViewById(R.id.ServiceProvider_tvAlreadyAccountSignIn_SignUp);
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

        ServiceProvider_btnSignUp.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     //get data from editText into string variable

                                     String fullName=ServiceProvider_edtFullName_SignUp.getText().toString();
                                     String phoneNumber=ServiceProvider_edtPhone_SignUp.getText().toString();
                                     String password=ServiceProvider_edtPassword_SignUp.getText().toString();
                                     String confirmPassword=ServiceProvider_edtConfirmPassword_SignUp.getText().toString();

                                     ///check if user fill all fields before sending data to firebase
                                     if(fullName.isEmpty()||phoneNumber.isEmpty()
                                             ||password.isEmpty()||confirmPassword.isEmpty())
                                     {
                                         Toast.makeText(serviceProviderSignUp.this,
                                                 "Please fill all fields",Toast.LENGTH_SHORT).show();
                                     }
                                     //check if password are matching with each other
                                      else if(!password.equals(confirmPassword))
                                     {
                                         Toast.makeText(serviceProviderSignUp.this,
                                                 "Password are not matching",Toast.LENGTH_SHORT).show();
                                     }
                                     //sending data to firebase realtimedarabase
                                     //we are using phone number as unique identity of every user
                                     //so all the other details of user comes under phone number

                                      else
                                      {

                                          databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                  //check if phone number is not register before
                                                  if(snapshot.hasChild(phoneNumber))
                                                  {
                                                      Toast.makeText(serviceProviderSignUp.this,
                                                              "Phone number is already registered",Toast.LENGTH_SHORT).show();
                                                  }
                                                  else
                                                  {
                                                      databaseReference.child("users").child(phoneNumber).child("fullname").setValue(fullName);
                                                      databaseReference.child("users").child(phoneNumber).child("password").setValue(password);
                                                      Toast.makeText(serviceProviderSignUp.this,
                                                              "User register successfully",Toast.LENGTH_SHORT).show();
                                                      finish();
                                                  }
                                              }

                                              @Override
                                              public void onCancelled(@NonNull DatabaseError error) {

                                              }
                                          });

                                      }
                                 }
                             });

       /* tvAlreadyAccount.setOnClickListener(view -> {
            Intent intent = new Intent(serviceProviderSignUp.this, sign_in_for_service_provider.class);
            startActivity(intent);
        });*/

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