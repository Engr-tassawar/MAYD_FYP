package com.example.mayd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class service_provider_profile_fragment extends Fragment {



    public service_provider_profile_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout S_Provider_tabLayout;
        ViewPager S_Provider_viewpager;

        S_Provider_viewpager = getView().findViewById(R.id.S_Provider_viewpager);
        S_Provider_tabLayout = getView().findViewById(R.id.S_Provider_tabLayout);

        S_Provider_tabLayout.setupWithViewPager(S_Provider_viewpager);
        fragmentAdapter adapter=new fragmentAdapter(getFragmentManager());
        S_Provider_viewpager.setAdapter(adapter);
       /* fragmentAdapter adapter=new fragmentAdapter(getSupportFragmentManager());*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_service_provider_profile_fragment, container, false);



    }
}