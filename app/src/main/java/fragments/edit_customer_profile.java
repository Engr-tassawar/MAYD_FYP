package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import Model.CustomerUser;


public class edit_customer_profile extends Fragment {
EditText edit_customer_name,edit_customer_email,edit_customer_phone;
AppCompatButton edit_customer_btnSave;
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

    public edit_customer_profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment edit_customer_profile.
     */
    // TODO: Rename and change types and number of parameters
    public static edit_customer_profile newInstance(String param1, String param2) {
        edit_customer_profile fragment = new edit_customer_profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_customer_name=getView().findViewById(R.id.edit_customer_name);
        edit_customer_email=getView().findViewById(R.id.edit_customer_email);
        edit_customer_phone=getView().findViewById(R.id.edit_customer_phone);
        edit_customer_btnSave=getView().findViewById(R.id.edit_customer_btnSave);

        database.getReference().child("CustomerUsers").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    CustomerUser customerUser = snapshot.getValue(CustomerUser.class);
                    /*Picasso.get()
                            .load(customerUser.getCustomerProfile())
                            .placeholder(R.drawable.profile_image_b)
                            .into(customer_profile);*/
                    edit_customer_name.setText(customerUser.getCustomerFullName());
                    edit_customer_phone.setText(customerUser.getCustomerPhone());
                    edit_customer_email.setText(customerUser.getCustomerEmail());



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
        View view=inflater.inflate(R.layout.fragment_edit_customer_profile, container, false);
    return view;
    }
}