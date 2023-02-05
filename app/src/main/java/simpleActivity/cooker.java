package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import Model.Order;
import Model.ServiceTypes;
import Utils.Common;
import Utils.Services;

public class cooker extends AppCompatActivity {
    TextView tv_monthlyCook,tv_fullDay,tv_cookHelper_houseKeeping,tv_partTime;
    CheckBox monthlyCook_CheckBox,fullDay_CheckBox,cookHelper_houseKeeping_CheckBox,partTime_CheckBox;
    Button cookPackage;
    Order order= new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooker);
        monthlyCook_CheckBox=findViewById(R.id.monthlyCook_CheckBox);
        fullDay_CheckBox=findViewById(R.id.fullDay_CheckBox);
        cookHelper_houseKeeping_CheckBox=findViewById(R.id.cookHelper_houseKeeping_CheckBox);
        partTime_CheckBox=findViewById(R.id.partTime_CheckBox);
        cookPackage=findViewById(R.id.cookPackage);
        tv_monthlyCook=findViewById(R.id.tv_monthlyCook);
        tv_fullDay=findViewById(R.id.tv_fullDay);
        tv_cookHelper_houseKeeping=findViewById(R.id.tv_cookHelper_houseKeeping);
        tv_partTime=findViewById(R.id.tv_partTime);

        order.ServiceProviderType = ServiceTypes.Cook;

        Toolbar toolbar=findViewById(R.id.toolbar_cook);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cooker Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        monthlyCook_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fullDay_CheckBox.setChecked(false);
                    cookHelper_houseKeeping_CheckBox.setChecked(false);
                    partTime_CheckBox.setChecked(false);
                    order.ServiceDescription = "Regular Monthly Cook";
                    order.price="20000";
                    cookPackage.setEnabled(true);
                }
                else{
                    cookPackage.setEnabled(false);
                }
            }
        });
        fullDay_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    monthlyCook_CheckBox.setChecked(false);
                    cookHelper_houseKeeping_CheckBox.setChecked(false);
                    partTime_CheckBox.setChecked(false);
                    order.ServiceDescription = "Full Day";
                    order.price="1500";
                    cookPackage.setEnabled(true);
                }
                else{
                    cookPackage.setEnabled(false);
                }
            }
        });
        cookHelper_houseKeeping_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    monthlyCook_CheckBox.setChecked(false);
                    fullDay_CheckBox.setChecked(false);
                    partTime_CheckBox.setChecked(false);
                    order.ServiceDescription = "Cook helper + House keeping";
                    order.price="30000";
                    cookPackage.setEnabled(true);
                }
                else{
                    cookPackage.setEnabled(false);
                }
            }
        });
        partTime_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    monthlyCook_CheckBox.setChecked(false);
                    fullDay_CheckBox.setChecked(false);
                    cookHelper_houseKeeping_CheckBox.setChecked(false);
                    order.ServiceDescription = "Part time(2 Hrs max daily)";
                    order.price="10500";
                    cookPackage.setEnabled(true);
                }
                else{
                    cookPackage.setEnabled(false);
                }
            }
        });


        cookPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cooker.this, booking_schedule.class);
/*
                order.ServiceDescription="UPS Electrician";
*/
                Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();
            }
        });
       /* cookPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (monthlyCook_CheckBox.isChecked())
                {
                    driverClass.price= CookerOption.monthly_Cook_price;
                    driverClass.driverType= CookerOption.monthly_Cook;
                   *//* Toast.makeText(driver.this,
                            "Driver type is"+DriverOption.hireDriver, Toast.LENGTH_SHORT).show();*//*
                }
                if (fullDay_CheckBox.isChecked())
                {
                    driverClass.price=CookerOption.full_Day_Cook_price;
                    driverClass.driverType= CookerOption.full_Day_Cook;

                }
                if (cookHelper_houseKeeping_CheckBox.isChecked())
                {
                    driverClass.price=CookerOption.cook_houseKeeping_price;
                    driverClass.driverType= CookerOption.cook_houseKeeping;

                }
                if (partTime_CheckBox.isChecked())
                {
                    driverClass.price=CookerOption.partTime_2hrs_price;
                    driverClass.driverType= CookerOption.partTime_2hrs;

                }
                order.service = driverClass;
                order.ServiceDescription="Model.Driver";

                Intent intent = new Intent(cooker.this, booking_schedule.class);
                intent.putExtra("orderObject", order);
                startActivity(intent);

            }

        });*/
    }
    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }
}