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
import Model.ServiceTypes;
import Utils.Common;

public class driver extends AppCompatActivity {


    TextView tv_hireDriver_price,tv_chauffeur_price,tv_driver_cityToCity_price,tv_driver_withinCity_price;
    CheckBox hireDriver_CheckBox,chauffeur_CheckBox,driver_cityToCity_CheckBox,driver_withinCity_CheckBox;
    Button driverPackage;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;
    Order order = new Order();
    DriverClass driverClass;

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

        order.ServiceProviderType = ServiceTypes.Driver;

        hireDriver_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    chauffeur_CheckBox.setChecked(false);
                    driver_cityToCity_CheckBox.setChecked(false);
                    driver_withinCity_CheckBox.setChecked(false);
                    order.ServiceDescription = "Hire Driver 3-4 hours daily";
                    order.price="15000";
                    driverPackage.setEnabled(true);
                }
                else{
                    driverPackage.setEnabled(false);
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
                    order.ServiceDescription = "Chauffeur(24/7)";
                    order.price="35000";
                    driverPackage.setEnabled(true);
                }
                else{
                    driverPackage.setEnabled(false);
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
                    order.ServiceDescription = "Hire a Driver for 24/7";
                    order.price="2000";
                    driverPackage.setEnabled(true);
                }
                else{
                    driverPackage.setEnabled(false);
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
                    order.ServiceDescription = "Day Driver(within City)";
                    order.price="1500";
                    driverPackage.setEnabled(true);
                }
                else{
                    driverPackage.setEnabled(false);
                }
            }
        });
        driverPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(driver.this, booking_schedule.class);

                Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();
            }
        });

    }
}