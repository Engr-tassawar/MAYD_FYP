package com.example.mayd;

import android.content.Intent;
import android.icu.text.Replaceable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class booking_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      /*  on_Going=getView().findViewById(R.id.btn_onGoing);
        completed=getView().findViewById(R.id.btn_completed);

        on_Going.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment complete=new completed_fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.bottomNavigation,complete).commit();

            }
        });*/
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_booking_fagment, container, false);

    }
}
