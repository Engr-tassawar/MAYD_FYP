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

public class home_fragment extends Fragment {

    Button btnSign;
    ImageView imgElectric,imgPlum,imgGraphic,imgAc,imgCook,imgDrive;
    TextView tvElectric,tvPlum,tvGraphic,tvAc,tvCook,tvDrive;
    CardView driverCardView,plumberCardView,electricianCardView,houseKeepingCardView,graphicCardView,Ac_CardView,painterCardView,cookCardView;



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
        btnSign=getView().findViewById(R.id.btnSign);

        driverCardView=getView().findViewById(R.id.driverCardView);
        houseKeepingCardView=getView().findViewById(R.id.houseKeepingCardView);
        painterCardView=getView().findViewById(R.id.painterCardView);
        cookCardView=getView().findViewById(R.id.cookCardView);
        Ac_CardView=getView().findViewById(R.id.Ac_CardView);
        driverCardView=getView().findViewById(R.id.driverCardView);
        electricianCardView=getView().findViewById(R.id.electricianCardView);
        graphicCardView=getView().findViewById(R.id.graphicCardView);
        plumberCardView=getView().findViewById(R.id.plumberCardView);
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
                Intent intent = new Intent(getContext(),driver.class);
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
