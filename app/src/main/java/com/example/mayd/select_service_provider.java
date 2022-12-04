package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import Model.Order;
import Utils.Common;

public class select_service_provider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_provider);

        Order order = Common.getOrderObject(select_service_provider.this);

        search_fragment fragment = search_fragment.newInstance(order);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutForServiceProviderDisplay,fragment).commit();

    }
}