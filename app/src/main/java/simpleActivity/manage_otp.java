package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class manage_otp extends AppCompatActivity {
    EditText putOtpEdt;
    Button ServiceProvider_putOtp_btn;
    String phoneNumber;
    String otpid;
    FirebaseAuth mAuth;
    String _fullName,_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_otp);
        putOtpEdt = findViewById(R.id.putOtpEdt);
        ServiceProvider_putOtp_btn = findViewById(R.id.ServiceProvider_putOtp_btn);

       phoneNumber = getIntent().getStringExtra("mobile".toString());
        /*_city = getIntent().getStringExtra("city".toString());
        _fullName = getIntent().getStringExtra("fullName".toString());*/


        mAuth=FirebaseAuth.getInstance();
        initiateotp();
        ServiceProvider_putOtp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (putOtpEdt.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Blank field cannot be processed",Toast.LENGTH_SHORT).show();

                } else if (putOtpEdt.getText().toString().length()!=6) {
                    Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_SHORT).show();

                }
                else{
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpid,putOtpEdt.getText().toString());
                    signInWithPhoneAuthCredential(credential);

                }
            }
        });

    }

    private void initiateotp() {

PhoneAuthProvider.getInstance().verifyPhoneNumber(
        phoneNumber,
        60L,
        TimeUnit.SECONDS,
        this,
        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            otpid=s;
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }
);
                /*PhoneAuthOptions.newBuilder(mAuth)
                        .phoneNumbersetPhoneNumber()       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);*/

    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseDatabase.getInstance().getReference("ServiceProviderUsers")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                                        @Override
                                        public void onSuccess(DataSnapshot dataSnapshot) {
                                          if(dataSnapshot.exists())
                                          {
                                              Intent intent = new Intent(manage_otp.this, service_provider_home.class);
                                              startActivity(intent);
                                              finish();
                                          }
                                          else {
                                              Intent intent = new Intent(manage_otp.this, add_provider_detail.class);
                                              startActivity(intent);
                                              finish();
                                          }
                                        }
                                    });

/*
                            storeNewUserData();
*/
                           /*startActivity((new Intent(manage_otp.this, service_provider_home.class)));
                           finish();*/
                        } else {
                            Toast.makeText(getApplicationContext(),"SignIn Code Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /*private void storeNewUserData() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("ServiceProviderUsers");
        User user=new User(_fullName,_city,phoneNumber);
        reference.setValue(user);
    }*/
}
