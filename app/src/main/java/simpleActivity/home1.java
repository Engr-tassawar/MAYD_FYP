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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayd.R;

import Model.CustomerUser;
import fragments.customer_profile;
import fragments.search_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import fragments.booking_fragment;
import fragments.home_fragment;
import fragments.support_fragment;
import fragments.terms_fragment;

public class home1 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    ImageView drawerCircleImage;
    TextView drawerCustomerProfileName;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FirebaseStorage storage;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        drawerCustomerProfileName=findViewById(R.id.drawerCustomerProfileName);
        drawerCircleImage=findViewById(R.id.drawerCustomerProfile);
        toolbar = findViewById(R.id.toolbar);
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();
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
       /* database.getReference().child("CustomerUsers").child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    CustomerUser customerUser = snapshot.getValue(CustomerUser.class);
                    Picasso.get()
                            .load(customerUser.getCustomerProfile())
                            .placeholder(R.drawable.profile_image_b)
                            .into(drawerCircleImage);
                    drawerCustomerProfileName.setText(customerUser.getCustomerEmail());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.myFrameLayout,new home_fragment())
                                                .commit();

                        break;
                    case R.id.C_Profile:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.myFrameLayout,new customer_profile())
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
                /*else if(item.getItemId()==R.id.Users_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.myFrameLayout,new search_fragment()).commit();

                }*/


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
