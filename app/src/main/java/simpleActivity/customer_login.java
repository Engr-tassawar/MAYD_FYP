package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;
import com.example.mayd.register_number;
import com.example.mayd.sign_in_ForCustomer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class customer_login extends AppCompatActivity {
    EditText customer_edtEmail_SignIn, customer_edtPassword_SignIn;
    Button customer_btnSendCode_SignIn, btnService;
    TextView customer_tvSignUp, service_provider_number, forgot_password_customer;
    FirebaseUser currentUser;
    AlertDialog.Builder reset_alert;
    FirebaseAuth auth;
    LayoutInflater inflater;
   /*DatabaseReference databaseReference= FirebaseDatabase.getInstance().
            getReferenceFromUrl("https://mayd-535a0-default-rtdb.asia-southeast1.firebasedatabase.app/");*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_login);
        //getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
/*
        currentUser=auth.getCurrentUser();
*/
        reset_alert = new AlertDialog.Builder(this);
        inflater = this.getLayoutInflater();
        customer_edtEmail_SignIn = findViewById(R.id.customer_edtEmail_SignIn);

        forgot_password_customer = findViewById(R.id.forgot_password_customer);
        customer_edtPassword_SignIn = findViewById(R.id.customer_edtPassword_SignIn);
        customer_btnSendCode_SignIn = findViewById(R.id.customer_btnSendCode_SignIn);
        btnService = findViewById(R.id.btnService);
/*
        service_provider_number = findViewById(R.id.service_provider_number);
*/
        customer_tvSignUp = findViewById(R.id.customer_tvSignUp_SignIn_P1);
        forgot_password_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View pop = inflater.inflate(R.layout.reset_pop, null);
                reset_alert.setTitle("Reset Forgot Password")
                        .setMessage("Enter Your Email to get Password Reset Link")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText email = pop.findViewById(R.id.forgot_password_email);
                                if (email.getText().toString().isEmpty()) {
                                    email.setError("Required Field");
                                    return;
                                }
                                auth.sendPasswordResetEmail(email.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(customer_login.this,
                                                "Reset Email is sent", Toast.LENGTH_SHORT).show();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(customer_login.this,
                                                e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        }).setNegativeButton("Cancel", null)
                        .setView(pop)
                        .create().show();
            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customer_login.this, register_number.class);
                startActivity(intent);
            }
        });
        customer_btnSendCode_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
                String email = Service_Provider_edtEmail_SignIn.getText().toString();
*/

                String email = customer_edtEmail_SignIn.getText().toString();
                String Password = customer_edtPassword_SignIn.getText().toString();
                if (email.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(customer_login.this,
                            "Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    customer_edtEmail_SignIn.setError("Please enter valid email");
                    customer_edtEmail_SignIn.requestFocus();
                    return;
                }
                if (Password.length() < 6) {
                    customer_edtPassword_SignIn.setError("Minimum password length should be 6 character");
                    customer_edtPassword_SignIn.requestFocus();
                    return;
                }
                auth.signInWithEmailAndPassword(email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(customer_login.this,
                                    "Successfully Logged In", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(customer_login.this, home1.class));
                            finish();
                        } else {
                            Toast.makeText(customer_login.this,
                                    "Failed to Log in", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        customer_tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customer_login.this, customer_registration.class);
                startActivity(intent);
            }
        });
       /* Service_Provider_btnSendCode_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = Service_Provider_edtPhone_SignIn.getText().toString();
                String password = Service_Provider_edtPassword_SignIn.getText().toString();
                if(phone.isEmpty()||password.isEmpty())
                {
                    Toast.makeText(sign_in_for_service_provider.this,
                            "Please enter your mobile or password",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phone))
                            {
                               String getPassword=snapshot.child(phone).child("password").getValue(String.class);
                               if(getPassword.equals(password))
                               {
                                   Toast.makeText(sign_in_for_service_provider.this,
                                           "Successfully Logged In",Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(sign_in_for_service_provider.this, selectService_for_ServiceProvider.class));
                                   finish();

                               }
                               else
                               {
                                   Toast.makeText(sign_in_for_service_provider.this,
                                           "Wrong Password",Toast.LENGTH_SHORT).show();
                               }
                            }
                            else
                            {
                                Toast.makeText(sign_in_for_service_provider.this,
                                        "Wrong Password",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
               *//* Intent intent = new Intent(sign_in_for_service_provider.this, selectService_for_ServiceProvider.class);
                startActivity(intent);*//*
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_for_service_provider.this, serviceProviderSignUp.class);
                startActivity(intent);
            }
        });
    }*/

  /*  @Override
    protected void onStart() {
        super.onStart();
        if (currentUser!=null){

            Intent intent=new Intent(sign_in_for_service_provider.this,service_provider_home.class);
            startActivity(intent);
            onBackPressed();
            finish();
        }
    }*/
    }
}