package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mayd.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import fragments.booking_fragment;
import fragments.home_fragment;
import fragments.support_fragment;
import fragments.terms_fragment;

public class home1 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    FirebaseAuth mAuth;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        toolbar = findViewById(R.id.toolbar);

        mAuth=FirebaseAuth.getInstance();
        //getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new home_fragment()).commit();
        //navigationView.setCheckedItem(R.id.home);



        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(home1.this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.myFrameLayout,new home_fragment())
                                                .commit();

                        break;
                    case R.id.booking:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.myFrameLayout,new booking_fragment())
                                .commit();
                        break;

                    case R.id.support:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.myFrameLayout,new support_fragment())
                                .commit();
                        break;
                    case R.id.terms:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.myFrameLayout,new terms_fragment())
                                .commit();
                        break;
                    case R.id.logOut:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getApplicationContext(), customer_login.class);
                        startActivity(intent);
                        finish();
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });




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
