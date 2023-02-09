package com.example.mayd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import Model.CustomerUser;
import Model.serviceProviderRecord;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link service_provider_drawer_profile_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class service_provider_drawer_profile_fragment extends Fragment {
    TextView S_service,S_phone,S_fulName,S_MainProfileName;
    ImageView service_circleImageView;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public service_provider_drawer_profile_fragment() {
        // Required empty public constructor
    }


    public static service_provider_drawer_profile_fragment newInstance(String param1, String param2) {
        service_provider_drawer_profile_fragment fragment = new service_provider_drawer_profile_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        S_service=getView().findViewById(R.id.C_email);
        S_phone=getView().findViewById(R.id.C_phone);
        S_MainProfileName=getView().findViewById(R.id.C_MainProfileName);
        service_circleImageView=getView().findViewById(R.id.circleImageView);
        S_fulName=getView().findViewById(R.id.C_fulName);

     /*database.getReference().child("ServiceProviderUsers").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                serviceProviderRecord ServiceProviderRecord =snapshot.getValue(serviceProviderRecord.class);
                    Picasso.get()
                            .load(ServiceProviderRecord.getServiceProviderProfile())
                            .placeholder(R.drawable.profile_image_b)
                            .into(service_circleImageView);
                    S_service.setText(ServiceProviderRecord.getServiceProviderService());
                    S_phone.setText(auth.getCurrentUser().getPhoneNumber());
                    S_fulName.setText(ServiceProviderRecord.getFirstName()+" "+ServiceProviderRecord.getLastName());
                    S_MainProfileName.setText(ServiceProviderRecord.getFirstName()+" "+ServiceProviderRecord.getLastName());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/




    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            auth=FirebaseAuth.getInstance();
            storage=FirebaseStorage.getInstance();
            database=FirebaseDatabase.getInstance();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_service_provider_drawer_profile_fragment, container, false);

   return view;
    }
}