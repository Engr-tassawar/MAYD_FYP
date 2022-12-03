package fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import Model.CustomerUser;
import simpleActivity.cooker;
import simpleActivity.driver;
import simpleActivity.electrician_properties;
import simpleActivity.graphic_designer;
import simpleActivity.house_keeping;
import simpleActivity.hvacr;
import simpleActivity.painter;
import simpleActivity.plumber_properties;

public class home_fragment extends Fragment {

    Button btnSignOut;
    /*ImageView customer_profile,add_customer_image;*/
    ImageView imgElectric,imgPlum,imgGraphic,imgAc,imgCook,imgDrive;
    TextView tvElectric,tvPlum,tvGraphic,tvAc,tvCook,tvDrive,tvName,tvId;
    CardView driverCardView,plumberCardView,electricianCardView,houseKeepingCardView,graphicCardView,Ac_CardView,painterCardView,cookCardView;
    ActivityResultLauncher<String> launcher;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;

    public home_fragment() {
        // Required empty public constructor

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        imgElectric=getView().findViewById(R.id.imgElectric);
        imgPlum=getView().findViewById(R.id.imgPlum);
        imgGraphic=getView().findViewById(R.id.imgGraphic);
        imgAc=getView().findViewById(R.id.imgAc);
        imgCook=getView().findViewById(R.id.imgCook);
        imgDrive=getView().findViewById(R.id.imgDrive);
        tvElectric=getView().findViewById(R.id.tvElectric);
        tvPlum=getView().findViewById(R.id.tvPlum);
        tvGraphic=getView().findViewById(R.id.tvGraphic);
        tvAc=getView().findViewById(R.id.tvAc);
        tvCook=getView().findViewById(R.id.tvCook);
        tvDrive=getView().findViewById(R.id.tvDrive);
        /*btnSignOut=getView().findViewById(R.id.btnSignOut);*/

        driverCardView=getView().findViewById(R.id.driverCardView);
        houseKeepingCardView=getView().findViewById(R.id.houseKeepingCardView);
        painterCardView=getView().findViewById(R.id.painterCardView);
        cookCardView=getView().findViewById(R.id.cookCardView);
        Ac_CardView=getView().findViewById(R.id.Ac_CardView);
        driverCardView=getView().findViewById(R.id.driverCardView);
        electricianCardView=getView().findViewById(R.id.electricianCardView);
        graphicCardView=getView().findViewById(R.id.graphicCardView);
        plumberCardView=getView().findViewById(R.id.plumberCardView);
       /* btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        plumberCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), plumber_properties.class);
                startActivity(intent);

            }
        });
        electricianCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), electrician_properties.class);
                startActivity(intent);
            }
        });
        graphicCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), graphic_designer.class);
                startActivity(intent);
            }
        });
        Ac_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), hvacr.class);
                startActivity(intent);

            }
        });
        cookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), cooker.class);
                startActivity(intent);

            }
        });
        painterCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), painter.class);
                startActivity(intent);

            }
        });
        houseKeepingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), house_keeping.class);
                startActivity(intent);

            }
        });
        driverCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getContext(), driver.class);
                startActivity(intent);

            }
        });

        ImageView add_customer_image, customer_profile;
        add_customer_image = getView().findViewById(R.id.add_customer_image);
        customer_profile= getView().findViewById(R.id.customer_profile);
        tvName = getView().findViewById(R.id.tvName);
        tvId = getView().findViewById(R.id.tvId);
        database.getReference().child("CustomerUsers").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    CustomerUser customerUser = snapshot.getValue(CustomerUser.class);
                    Picasso.get()
                            .load(customerUser.getCustomerProfile())
                            .placeholder(R.drawable.profile_image_b)
                            .into(customer_profile);
                    tvName.setText(customerUser.getCustomerFullName());
                    tvId.setText(customerUser.getCustomerPhone());



                   /* String profile_photo=snapshot.getValue(String.class);
                    Picasso.get()
                            .load(profile_photo)
                            .placeholder(R.drawable.profile_image_b)
                            .into(customer_profile);*/

/*
                service_provider_number.setText(user.getFullName());
*/


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
                        customer_profile.setImageURI(uri);
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
                                                Toast.makeText(getContext(),
                                                        "Profile photo saved", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
        add_customer_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch("image/*");
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragment, container, false);


        return view;
    }


 /* @Override
    public void onBackPressed() {
      new AlertDialog.Builder(this)
              .setIcon(R.drawable.ic_baseline_warning_24)
              .setTitle("Exit")
              .setMessage(("Are you sure to want exit?"))
              .setCancelable(false)
              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      finish();
                  }
              })
              .setNegativeButton("No",null)
        .show();
    }*/

}
