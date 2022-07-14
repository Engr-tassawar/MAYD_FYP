package com.example.mayd;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_fragment extends Fragment {

    Button btnSign;
    ImageView imgElectric,imgPlum,imgElder,imgBaby,imgCook,imgDrive;
    TextView tvElectric,tvPlum,tvElder,tvBaby,tvCook,tvDrive;
    CardView driverCardView,plumberCardView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_fragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgElectric=getView().findViewById(R.id.imgElectric);
        imgPlum=getView().findViewById(R.id.imgPlum);
        imgElder=getView().findViewById(R.id.imgElder);
        imgBaby=getView().findViewById(R.id.imgBaby);
        imgCook=getView().findViewById(R.id.imgCook);
        imgDrive=getView().findViewById(R.id.imgDrive);
        tvElectric=getView().findViewById(R.id.tvElectric);
        tvPlum=getView().findViewById(R.id.tvPlum);
        tvElder=getView().findViewById(R.id.tvElder);
        tvBaby=getView().findViewById(R.id.tvBaby);
        tvCook=getView().findViewById(R.id.tvCook);
        tvDrive=getView().findViewById(R.id.tvDrive);
        btnSign=getView().findViewById(R.id.btnSign);
        driverCardView=getView().findViewById(R.id.driverCardView);


        plumberCardView=getView().findViewById(R.id.plumberCardView);
        plumberCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), plumber_properties.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragment, container, false);

    }

}
