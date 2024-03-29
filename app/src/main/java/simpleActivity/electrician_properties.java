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

import Model.Order;
import Model.ServiceTypes;
import Utils.Common;

public class electrician_properties extends AppCompatActivity {
    TextView tvGenerator,tvUPS;
    CheckBox generator_CheckBox,UPSCheckBox;
    Button electricianPackage;
    Order order= new Order();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_properties);
        generator_CheckBox=findViewById(R.id.generator_CheckBox);
        UPSCheckBox=findViewById(R.id.UPSCheckBox);
        tvGenerator=findViewById(R.id.tv_generator);
        tvUPS=findViewById(R.id.tvUPS);
        electricianPackage=findViewById(R.id.electricianPackage);
        electricianPackage.setEnabled(false);
        order.ServiceProviderType= ServiceTypes.Electrician;
        Toolbar toolbar=findViewById(R.id.toolbar_electrician);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Electrician Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        generator_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UPSCheckBox.setChecked(false);
                    order.ServiceDescription = "Generator Installation";
                    order.price="2000";
                    electricianPackage.setEnabled(true);
                }else{
                    electricianPackage.setEnabled(false);
                }
            }
        });
        UPSCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    generator_CheckBox.setChecked(false);
                    order.ServiceDescription = "UPS Installation";
                    order.price="1500";
                    electricianPackage.setEnabled(true);

                }else{
                    electricianPackage.setEnabled(false);
                }
            }
        });


        electricianPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electrician_properties.this, booking_schedule.class);
/*
                order.ServiceDescription="UPS Electrician";
*/
                Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }
}