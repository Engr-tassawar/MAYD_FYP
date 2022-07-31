package com.example.mayd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class home1 extends AppCompatActivity {

BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
 /* NavigationView navigationView;
   DrawerLayout drawerLayout;*/

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        toolbar = findViewById(R.id.toolbar);

        //getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new home_fragment()).commit();
        //navigationView.setCheckedItem(R.id.home);


       /*
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(home1.this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.home_icon)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new home_fragment()).commit();
                }
                else if(item.getItemId()==R.id.support_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new support_fragment()).commit();

                }
                else if(item.getItemId()==R.id.booking_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new booking_fragment()).commit();

                }


               /* switch (item.getItemId())
                {
                    case R.id.home_icon:
                }*/
                return false;
            }
        });
    }

    @Override
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
    }
}
