package fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayd.R;

import Model.User;
import adapters.fragmentAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class service_provider_profile_fragment extends Fragment {
ActivityResultLauncher<String> launcher;

FirebaseAuth auth;
FirebaseStorage storage;
FirebaseDatabase database;


    public service_provider_profile_fragment() {
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
        ImageView add_provider_image, service_provider_profile;
        TabLayout S_Provider_tabLayout;
        ViewPager S_Provider_viewpager;
        Button ServiceProvider_btnSignOut;
        TextView service_provider_number,service_provider_name;
        ServiceProvider_btnSignOut = getView().findViewById(R.id.ServiceProvider_btnSignOut);
        S_Provider_tabLayout = getView().findViewById(R.id.S_Provider_tabLayout);
        S_Provider_viewpager = getView().findViewById(R.id.S_Provider_viewpager);
        S_Provider_tabLayout.setupWithViewPager(S_Provider_viewpager);
        fragmentAdapter adapter = new fragmentAdapter(getFragmentManager());
        S_Provider_viewpager.setAdapter(adapter);

        service_provider_name = getView().findViewById(R.id.service_provider_name);

        service_provider_number = getView().findViewById(R.id.service_provider_number);
        service_provider_profile= getView().findViewById(R.id.service_provider_profile);
        add_provider_image = getView().findViewById(R.id.add_provider_image);

        ServiceProvider_btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();

            }

            private void finish() {

            }
        });
        database.getReference().child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                /*if (snapshot.exists()) {
                    User user = snapshot.getValue(User.class);
                    Picasso.get()
                            .load(user.getProviderProfilePhoto())
                            .placeholder(R.drawable.profile_image_b)
                            .into(service_provider_profile);
                   *//* service_provider_number.setText(user.getPhoneNumber());
                    service_provider_name.setText(user.getFullName());*//*

                }*/

               /* if (snapshot.exists()) {
                    String profile_photo = snapshot.getValue(String.class);
                    Picasso.get()
                            .load(profile_photo)
                            .placeholder(R.drawable.profile_image_b)

                            .into(service_provider_profile);
                }*/
                /*if (snapshot.exists()) {

                User user=snapshot.getValue(User.class);
                service_provider_number.setText(user.getFullname());
                }*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        launcher=registerForActivityResult(new ActivityResultContracts.GetContent()
                , new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        service_provider_profile.setImageURI(uri);
                        final StorageReference reference = storage.getReference().child("Provider_Profile_Photo")
                                .child(FirebaseAuth.getInstance().getUid());
                        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                Toast.makeText(getContext(),
                                        "Profile photo saved", Toast.LENGTH_SHORT).show();
                                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        database.getReference().child("Users").child(auth.getUid()).child("providerProfilePhoto").setValue(uri.toString());
                                               /* .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {

                                                    }
                                                });*/
                                    }
                                });
                            }
                        });
                    }
                });
        add_provider_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcher.launch("image/*");
            }
        });
       /* add_provider_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);

            }

        });
           database.getReference().child("user").child(auth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {

                   User user = snapshot.getValue(User.class);

                   if (snapshot.exists()) {
                       Picasso.get()
                               .load(user.getProfile())
                               .placeholder(R.drawable.profile_image_b)
                               .into(service_provider_profile);

                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });*/
    }

    @Override
       public View onCreateView (LayoutInflater inflater, ViewGroup container,
               Bundle savedInstanceState){
           // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service_provider_profile_fragment, container, false);



           return view;
       }

   /* @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView service_provider_profile;
        service_provider_profile= getView().findViewById(R.id.service_provider_profile);

             if (requestCode==11) {
                 if (data.getData() != null) {
                     Uri uri = data.getData();
                     service_provider_profile.setImageURI(uri);
                     final StorageReference reference = storage.getReference().child("profile_photo")
                             .child(FirebaseAuth.getInstance().getUid());
                     reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                             Toast.makeText(getContext(),
                                     "Profile photo saved", Toast.LENGTH_SHORT).show();
                             reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                 @Override
                                 public void onSuccess(Uri uri) {
                                     database.getReference().child("user").child(auth.getUid()).
                                             child("profile_photo").setValue(uri.toString());

                                 }
                             });
                         }
                     });
                 }
             }
    }*/
}
