package simpleActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mayd.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import fragments.booking_fragment;
import fragments.service_provider_profile_fragment;
import fragments.support_fragment;
import fragments.terms_fragment;

public class service_provider_home extends AppCompatActivity {

    BottomNavigationView service_provider_bottomNavigation;
    ActionBarDrawerToggle toggle;
    Toolbar service_provider_toolbar;
    FirebaseAuth mAuth;
    NavigationView service_provider_navigationView;
    DrawerLayout service_provider_drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_home);

        mAuth=FirebaseAuth.getInstance();
        service_provider_bottomNavigation=findViewById(R.id.service_provider_bottomNavigation);
        service_provider_toolbar = findViewById(R.id.service_provider_toolbar);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.service_provider_FrameLayout,new service_provider_profile_fragment())
                .commit();

        service_provider_drawerLayout = findViewById(R.id.service_provider_drawerLayout);
        service_provider_navigationView=findViewById(R.id.service_provider_navigationView);
        setSupportActionBar(service_provider_toolbar);
        toggle = new ActionBarDrawerToggle(service_provider_home.this, service_provider_drawerLayout, service_provider_toolbar, R.string.navigation_open, R.string.navigation_close);
        service_provider_drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        service_provider_navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.service_provider_FrameLayout,new service_provider_profile_fragment())
                                .commit();

                        break;
                    case R.id.booking:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.service_provider_FrameLayout,new booking_fragment())
                                .commit();
                        break;

                    case R.id.support:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.service_provider_FrameLayout,new support_fragment())
                                .commit();
                        break;
                    case R.id.terms:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.service_provider_FrameLayout,new terms_fragment())
                                .commit();
                        break;
                    case R.id.logOut:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        break;

                }
                service_provider_drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        service_provider_bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.home_icon)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_provider_FrameLayout,new service_provider_profile_fragment()).commit();
                return true;
                }
                else if(item.getItemId()==R.id.support_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_provider_FrameLayout,new support_fragment()).commit();
                    return true;

                }
                else if(item.getItemId()==R.id.booking_icon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.service_provider_FrameLayout,new booking_fragment()).commit();
                    return true;

                }


               /* switch (item.getItemId())
                {
                    case R.id.home_icon:
                }*/
                return false;
            }
        });
    }


}
