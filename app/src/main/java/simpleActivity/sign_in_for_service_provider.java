package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;
import com.example.mayd.sign_in_ForCustomer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sign_in_for_service_provider extends AppCompatActivity {
EditText Service_Provider_edtPhone_SignIn,Service_Provider_edtPassword_SignIn;
Button Service_Provider_btnSendCode_SignIn,btnCustomer;
TextView tvSignUp,service_provider_number;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().
            getReferenceFromUrl("https://mayd-535a0-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_for_sevice_provider);
        //getSupportActionBar().hide();
        Service_Provider_edtPhone_SignIn=findViewById(R.id.Service_Provider_edtPhone_SignIn);
        Service_Provider_edtPassword_SignIn=findViewById(R.id.Service_Provider_edtPassword_SignIn);
        Service_Provider_btnSendCode_SignIn=findViewById(R.id.Service_Provider_btnSendCode_SignIn);
        btnCustomer=findViewById(R.id.btnCustomer);
        service_provider_number=findViewById(R.id.service_provider_number);
        tvSignUp=findViewById(R.id.Service_Provider_tvSignUp_SignIn_P1);

        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in_for_service_provider.this, sign_in_ForCustomer.class);
                startActivity(intent);
            }
            });
        Service_Provider_btnSendCode_SignIn.setOnClickListener(new View.OnClickListener() {
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
               /* Intent intent = new Intent(sign_in_for_service_provider.this, selectService_for_ServiceProvider.class);
                startActivity(intent);*/
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_in_for_service_provider.this, serviceProviderSignUp.class);
                startActivity(intent);
            }
        });



    }
}