package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import Model.serviceProviderRecord;

public class add_provider_detail extends AppCompatActivity {
    EditText ServiceProvider_edtFirstName,ServiceProvider_edtLastName,ServiceProvider_edtCity;
    Button ServiceProvider_btnSave;
    FirebaseAuth firebaseAuth;
    FirebaseStorage storage;
    String userID;
    AutoCompleteTextView selectService_edt;
    String[] services={"Driver","Electrician","Plumber","HVCR","Graphics","Cook","Painter","Sweeper"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider_detail);
        ServiceProvider_edtFirstName=findViewById(R.id.ServiceProvider_edtFirstName);
        ServiceProvider_edtLastName=findViewById(R.id.ServiceProvider_edtLastName);
        ServiceProvider_edtCity=findViewById(R.id.ServiceProvider_edtCity);
        ServiceProvider_btnSave=findViewById(R.id.ServiceProvider_btnSave);




       selectService_edt=findViewById(R.id.selectService_edt);


        firebaseAuth=FirebaseAuth.getInstance();
        storage=FirebaseStorage.getInstance();
/*
        userID=firebaseAuth.getCurrentUser().getUid();
*/


      adapter=new ArrayAdapter<String>(add_provider_detail.this, R.layout.list_items,services);
/*
       adapter.setDropDownViewResource(android.R.layout.activity_list_item);
*/
       selectService_edt.setAdapter(adapter);
       selectService_edt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String value=adapterView.getItemAtPosition(i).toString();
               Toast.makeText(add_provider_detail.this,value, Toast.LENGTH_SHORT).show();
           }
       });

        ServiceProvider_btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ServiceProvider_edtFirstName.getText().toString().isEmpty()&&
                        !ServiceProvider_edtLastName.getText().toString().isEmpty()&&
                        !ServiceProvider_edtCity.getText().toString().isEmpty()&&
                        !selectService_edt.getText().toString().isEmpty())

                {
                    String firstName = ServiceProvider_edtFirstName.getText().toString();
                    String lastName = ServiceProvider_edtLastName.getText().toString();
                    String city = ServiceProvider_edtCity.getText().toString();
                    String services = selectService_edt.getText().toString();
                    String Phone = getIntent().getStringExtra("PhoneNumber").toString();

                    serviceProviderRecord serviceUser=new serviceProviderRecord(firstName,lastName,city,services,"ppp",Phone);

                    FirebaseDatabase.getInstance().getReference("ServiceProviderUsers")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(serviceUser)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(add_provider_detail.this, service_provider_home.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                    }
                else {
                    Toast.makeText(add_provider_detail.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
                return;
                }
            }
        });

        }
    }