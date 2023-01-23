package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayd.R;
import com.example.mayd.editCustomerProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import Model.CustomerUser;
import simpleActivity.driver;

public class customer_profile extends Fragment {
    TextView C_email,C_phone,C_fulName,C_MainProfileName;
    ImageView circleImageView;
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

    public customer_profile() {
        // Required empty public constructor
    }


    public static customer_profile newInstance(String param1, String param2) {
        customer_profile fragment = new customer_profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        C_email=getView().findViewById(R.id.C_email);
        C_phone=getView().findViewById(R.id.C_phone);
        C_MainProfileName=getView().findViewById(R.id.C_MainProfileName);
        circleImageView=getView().findViewById(R.id.circleImageView);
        C_fulName=getView().findViewById(R.id.C_fulName);
      /*  btn_editCustomerProfile=getView().findViewById(R.id.btn_editCustomerProfile);
        btn_editCustomerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), editCustomerProfile.class);
                startActivity(intent);
               *//* Fragment fragment=new edit_customer_profile();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.customerProfile,fragment).commit();*//*
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
                            .into(circleImageView);
                    C_email.setText(customerUser.getCustomerEmail());
                    C_phone.setText(customerUser.getCustomerPhone());
                    C_MainProfileName.setText(customerUser.getCustomerFullName());
                    C_fulName.setText(customerUser.getCustomerFullName());

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth=FirebaseAuth.getInstance();
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_customer_profile, container, false);

        return view;
    }
}