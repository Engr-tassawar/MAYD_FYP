package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mayd.R;
import adapters.customer_viewPager_adapter;
import com.google.android.material.tabs.TabLayout;


public class booking_fragment extends Fragment {

    public booking_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout customer_tabLayout;
        ViewPager customer_viewpager;

        customer_viewpager = getView().findViewById(R.id.customer_viewpager);
        customer_tabLayout = getView().findViewById(R.id.customer_tabLayout);

        customer_tabLayout.setupWithViewPager(customer_viewpager);
        customer_viewPager_adapter adapter=new customer_viewPager_adapter(getFragmentManager());
        customer_viewpager.setAdapter(adapter);
    }

    /* fragmentAdapter adapter=new fragmentAdapter(getSupportFragmentManager());*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_booking_fagment, container, false);

return view;

    }
}
