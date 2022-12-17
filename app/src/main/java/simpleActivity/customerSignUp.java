package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mayd.R;
import com.example.mayd.sign_in_ForCustomer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class customerSignUp extends AppCompatActivity {
    private static final String TAG = "tag";
    EditText Customer_edtFullNameSignUp, Customer_edtEmailSignUp, Customer_edtPhoneSignUp, Customer_edtPasswordSignUp, edtConfirmPassword;
    Button btnSignUp;
    TextView tvSignIn;
     FirebaseAuth mAuth;
     FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        //For hiding Action Bar
        //getSupportActionBar().hide();

database=FirebaseDatabase.getInstance();
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Customer_edtFullNameSignUp = findViewById(R.id.Customer_edtFullNameSignUp);
        Customer_edtEmailSignUp = findViewById(R.id.Customer_edtEmailSignUp);
        Customer_edtPhoneSignUp = findViewById(R.id.Customer_edtPhoneSignUp);
        Customer_edtPasswordSignUp = findViewById(R.id.Customer_edtPasswordSignUp);
        /* edtConfirmPassword = findViewById(R.id.Customer_edtConfirmPasswordSignUp);*/

        btnSignUp = findViewById(R.id.Customer_btnSignup_P2);
        tvSignIn = findViewById(R.id.tvAlreadyAccountSignUp_P2);

        tvSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(customerSignUp.this, sign_in_ForCustomer.class);
            startActivity(intent);
        });
     /* btnSignUp.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String customerFullName = Customer_edtFullNameSignUp.getText().toString().trim();
              String customerPhone = Customer_edtPhoneSignUp.getText().toString().trim();
              String customerEmail = Customer_edtEmailSignUp.getText().toString().trim();
              String customerPassword = Customer_edtPasswordSignUp.getText().toString().trim();

              if (customerFullName.isEmpty()) {
                  Customer_edtFullNameSignUp.setError("Please enter your name");
                  Customer_edtFullNameSignUp.requestFocus();
                  return;
              }
              if (customerPhone.isEmpty()) {
                  Customer_edtPhoneSignUp.setError("Please enter your phone number");
                  Customer_edtPhoneSignUp.requestFocus();
                  return;
              }
              if (customerEmail.isEmpty()) {
                  Customer_edtEmailSignUp.setError("Please enter your email");
                  Customer_edtEmailSignUp.requestFocus();
                  return;
              }
              if (customerPassword.isEmpty()) {
                  Customer_edtPasswordSignUp.setError("Please enter your email");
                  Customer_edtPasswordSignUp.requestFocus();
                  return;
              }
              if (!Patterns.EMAIL_ADDRESS.matcher(customerEmail).matches()) {
                  Customer_edtEmailSignUp.setError("Please enter valid email");
                  Customer_edtEmailSignUp.requestFocus();
                  return;
              }
              if (customerPassword.length() < 6) {
                  Customer_edtPasswordSignUp.setError("Minimum password length should be 6 character");
                  Customer_edtPasswordSignUp.requestFocus();
                  return;
              }
                  mAuth.createUserWithEmailAndPassword(customerEmail,customerPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful())
                          {

                              CustomerUser customerUser = new CustomerUser(customerFullName, customerPhone);

                              FirebaseDatabase.getInstance().getReference("CustomerUsers")
                                      .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                      .setValue(customerUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                          @Override
                                          public void onComplete(@NonNull Task<Void> task) {
                                              if (task.isSuccessful()) {
                                                  Toast.makeText(customerSignUp.this,
                                                          "User has been successfully registered", Toast.LENGTH_SHORT).show();
                                              }
                                              else {
                                                  Toast.makeText(customerSignUp.this,
                                                          "Failed to register!Try Again", Toast.LENGTH_SHORT).show();
                                              }
                                          }
                                      }).addOnFailureListener(new OnFailureListener() {
                                          @Override
                                          public void onFailure(@NonNull Exception e) {
                                              Toast.makeText(customerSignUp.this,
                                                      "Failed to register", Toast.LENGTH_SHORT).show();
                                          }
                                      });
                              *//*.addOnSuccessListener(new OnSuccessListener<Void>() {
                                          @Override
                                          public void onSuccess(Void unused) {
                                              Toast.makeText(customerSignUp.this,
                                                      "Successfuly register", Toast.LENGTH_SHORT).show();
                                          }
                                      });*//*
                          }
                      }
                  });
          }
      });*/
    }
}
       /* btnSignUp.setOnClickListener(view -> {

            if(validateInput()){
                //Send data in database
                mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    Log.d(TAG, "Account Created Successfully");

                                            FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.d(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(customerSignUp.this, "Authentication failed."+task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                  //  updateUI(null);
                                }
                            }
                        });
            }
        })
        };*/


   /* boolean validateInput()
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
    }*/

    /*public static boolean isValidEmail(CharSequence Email) {
        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }}*/

