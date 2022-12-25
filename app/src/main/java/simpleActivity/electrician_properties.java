package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mayd.R;

import Model.Order;
import Utils.Common;

public class electrician_properties extends AppCompatActivity {
    TextView tvGenerator,tvUPS;
    Button halfHourBtn_Electrician;
    CheckBox generator_CheckBox,UPSCheckBox;
    Button electricianPackage;
    Order order= new Order();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_properties);
        halfHourBtn_Electrician=findViewById(R.id.halfHourBtn_Electrician);
        generator_CheckBox=findViewById(R.id.generator_CheckBox);
        UPSCheckBox=findViewById(R.id.UPSCheckBox);
        tvGenerator=findViewById(R.id.tv_generator);
        tvUPS=findViewById(R.id.tvUPS);
        electricianPackage=findViewById(R.id.electricianPackage);
        electricianPackage.setEnabled(false);

        generator_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UPSCheckBox.setChecked(false);
                    order.ServiceProviderType = "Generator Installation";
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
                    order.ServiceProviderType = "UPS Installation";
                    order.price="1500";
                    electricianPackage.setEnabled(true);

                }else{
                    electricianPackage.setEnabled(false);
                }
            }
        });

        halfHourBtn_Electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electrician_properties.this, booking_schedule.class);
                startActivity(intent);
            }
        });
        electricianPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electrician_properties.this, booking_schedule.class);
/*
                order.ServiceProviderType="UPS Electrician";
*/
                Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();
            }
        });
    }

}