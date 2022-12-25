package com.example.mayd;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import Model.CustomerUser;
import fragments.customer_profile;
import simpleActivity.customer_login;
import simpleActivity.customer_registration;

public class editCustomerProfile extends AppCompatActivity {
  EditText edit_customer_name,edit_customer_email,edit_customer_phone;
  ImageView customerProfile;
 TextView ChangeCustomerProfile;
    AppCompatButton edit_customer_btnSave;
    ActivityResultLauncher<String> launcher;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_profile);
        edit_customer_name=findViewById(R.id.edit_customer_name);
        edit_customer_email=findViewById(R.id.edit_customer_email);
        customerProfile=findViewById(R.id.customerProfile);
        edit_customer_phone=findViewById(R.id.edit_customer_phone);
        ChangeCustomerProfile=findViewById(R.id.ChangeCustomerProfile);
        edit_customer_btnSave=findViewById(R.id.edit_customer_btnSave);
        auth=FirebaseAuth.getInstance();
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();
        user=auth.getCurrentUser();

/*       edit_customer_btnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(edit_customer_name.getText().toString().isEmpty()||edit_customer_email.getText().toString().isEmpty()||
                       edit_customer_phone.getText().toString().isEmpty()){
                   Toast.makeText(editCustomerProfile.this,
                           "One or many fields are empty", Toast.LENGTH_SHORT).show();
                   return;
               }
               final String email=edit_customer_email.getText().toString();
               user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {

                       Toast.makeText(editCustomerProfile.this,
                               "Email is changed", Toast.LENGTH_SHORT).show();
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(editCustomerProfile.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });*/

        database.getReference().child("CustomerUsers").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    CustomerUser customerUser = snapshot.getValue(CustomerUser.class);
                    Picasso.get()
                            .load(customerUser.getCustomerProfile())
                            .placeholder(R.drawable.profile_image_b)
                            .into(customerProfile);
                    edit_customer_name.setText(customerUser.getCustomerFullName());
                    edit_customer_phone.setText(customerUser.getCustomerPhone());
                    edit_customer_email.setText(customerUser.getCustomerEmail());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        launcher=registerForActivityResult(new ActivityResultContracts.GetContent()
                , new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        customerProfile.setImageURI(uri);
                        final StorageReference reference = storage.getReference().child("Customer_profile")
                                .child(FirebaseAuth.getInstance().getUid());
                        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
/*

                                Toast.makeText(getContext(),
                                        "Profile photo saved", Toast.LENGTH_SHORT).show();
*/

                                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        database.getReference().child("CustomerUsers").child(auth.getUid()).child("customerProfile").setValue(uri.toString())
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Toast.makeText(editCustomerProfile.this,
                                                                "Profile photo saved", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                    }
                                });
                            }
                        });
                    }
                });
        ChangeCustomerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch("image/*");
            }
        });
    }
}