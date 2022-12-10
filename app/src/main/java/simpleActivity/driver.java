package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mayd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.DriverClass;
import Model.DriverOption;
import Model.Order;

public class driver extends AppCompatActivity {


    TextView tv_hireDriver_price,tv_chauffeur_price,tv_driver_cityToCity_price,tv_driver_withinCity_price;
    CheckBox hireDriver_CheckBox,chauffeur_CheckBox,driver_cityToCity_CheckBox,driver_withinCity_CheckBox;
    Button driverPackage;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;
    Order order = new Order();
    DriverClass driverClass;
    int i=0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        driverClass=new DriverClass();
        auth=FirebaseAuth.getInstance();

        hireDriver_CheckBox=findViewById(R.id.hireDriver_CheckBox);
        chauffeur_CheckBox=findViewById(R.id.chauffeur_CheckBox);
        driver_cityToCity_CheckBox=findViewById(R.id.driver_cityToCity_CheckBox);
        driver_withinCity_CheckBox=findViewById(R.id.driver_withinCity_CheckBox);

        tv_hireDriver_price=findViewById(R.id.tv_hireDriver_price);
        tv_chauffeur_price=findViewById(R.id.tv_chauffeur_price);
        tv_driver_cityToCity_price=findViewById(R.id.tv_driver_cityToCity_price);
        tv_driver_withinCity_price=findViewById(R.id.tv_driver_withinCity_price);

        driverPackage=findViewById(R.id.driverPackage);


      /*  FirebaseDatabase.getInstance().getReference().child("CustomerUsers").child(auth.getUid()).child("work").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    i=(int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        hireDriver_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    chauffeur_CheckBox.setChecked(false);
                    driver_cityToCity_CheckBox.setChecked(false);
                    driver_withinCity_CheckBox.setChecked(false);
                }
            }
        });
        chauffeur_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hireDriver_CheckBox.setChecked(false);
                    driver_cityToCity_CheckBox.setChecked(false);
                    driver_withinCity_CheckBox.setChecked(false);
                }
            }
        });
        driver_cityToCity_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hireDriver_CheckBox.setChecked(false);
                    chauffeur_CheckBox.setChecked(false);
                    driver_withinCity_CheckBox.setChecked(false);
                }
            }
        });
        driver_withinCity_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hireDriver_CheckBox.setChecked(false);
                    chauffeur_CheckBox.setChecked(false);
                    driver_cityToCity_CheckBox.setChecked(false);
                }
            }
        });
        driverPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hireDriver_CheckBox.isChecked())
                {
                    driverClass.price=DriverOption.hireDriver_price;
                    driverClass.driverType= DriverOption.hireDriver;
                   /* Toast.makeText(driver.this,
                            "Driver type is"+DriverOption.hireDriver, Toast.LENGTH_SHORT).show();*/
                }
                if (chauffeur_CheckBox.isChecked())
                {
                    driverClass.price=DriverOption.Chauffeur_price;
                    driverClass.driverType= DriverOption.Chauffeur;

                }
                if (driver_cityToCity_CheckBox.isChecked())
                {
                    driverClass.price=DriverOption.hireForDriver_price;
                    driverClass.driverType= DriverOption.hireForDriver;

                }
                if (driver_withinCity_CheckBox.isChecked())
                {
                    driverClass.price=DriverOption.dayDriver_price;
                    driverClass.driverType= DriverOption.dayDriver;

                }
                order.service = driverClass;
                order.ServiceProviderType="Model.Driver";

                //Intent intent = new Intent(driver.this, book_your_service.class);
                Intent intent = new Intent(driver.this, booking_schedule.class);
                intent.putExtra("orderObject", order);
                startActivity(intent);

            }
        });

    }
}