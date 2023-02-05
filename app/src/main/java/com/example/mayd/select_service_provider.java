package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import Model.Order;
import Utils.Common;
import fragments.search_fragment;
import simpleActivity.booking_schedule;
import simpleActivity.driver;

public class select_service_provider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service_provider);
      /*  Toolbar toolbar=findViewById(R.id.toolbar_schedule);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Service Provider");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        Order order = Common.getOrderObject(select_service_provider.this);

        search_fragment fragment = search_fragment.newInstance(order);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutForServiceProviderDisplay,fragment).commit();


    }
   /* @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(select_service_provider.this, booking_schedule.class);
        startActivity(intent);
        onBackPressed();
        return true;
    }*/
}