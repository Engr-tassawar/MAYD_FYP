package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.mayd.R;

import Model.Order;
import Model.ServiceTypes;
import Utils.Common;

public class plumber_properties extends AppCompatActivity {
    CheckBox bathroomCheckBox,gasLineIronCheckBox,gasLinePlasticCheckBox,drainOpenerCheckBox;
    Button plumberPackage;
    Order order= new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_properties);
        bathroomCheckBox=findViewById(R.id.bathroomCheckBox);
        gasLineIronCheckBox=findViewById(R.id.gasLineIronCheckBox);
        gasLinePlasticCheckBox=findViewById(R.id.gasLinePlasticCheckbox);
        drainOpenerCheckBox=findViewById(R.id.drainOpenerCheckBox);
        plumberPackage=findViewById(R.id.plumberPackage);

        order.ServiceProviderType = ServiceTypes.Plumber;

        bathroomCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gasLineIronCheckBox.setChecked(false);
                    gasLinePlasticCheckBox.setChecked(false);
                    drainOpenerCheckBox.setChecked(false);
                    order.description = "Bathroom Fitting";
                    order.price="8000";
                    plumberPackage.setEnabled(true);
                }
                else{
                    plumberPackage.setEnabled(false);
                }
            }
        });
        gasLineIronCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    bathroomCheckBox.setChecked(false);
                    gasLinePlasticCheckBox.setChecked(false);
                    drainOpenerCheckBox.setChecked(false);
                    order.description
 = "Gas LIne Service(iron)";
                    order.price="6300";
                    plumberPackage.setEnabled(true);
                }
                else{
                    plumberPackage.setEnabled(false);
                }
            }
        });
        gasLinePlasticCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    bathroomCheckBox.setChecked(false);
                    gasLineIronCheckBox.setChecked(false);
                    drainOpenerCheckBox.setChecked(false);
                    order.description
 = "Gas LIne Service(plastic)";
                    order.price="4000";
                    plumberPackage.setEnabled(true);
                }
                else{
                    plumberPackage.setEnabled(false);
                }
            }
        });
        drainOpenerCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    bathroomCheckBox.setChecked(false);
                    gasLineIronCheckBox.setChecked(false);
                    gasLinePlasticCheckBox.setChecked(false);
                    order.description
 = "Drain Opener and Repair";
                    order.price="2000";
                    plumberPackage.setEnabled(true);
                }
                else{
                    plumberPackage.setEnabled(false);
                }
            }
        });

        plumberPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plumber_properties.this, booking_schedule.class);
             Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();

            }
        });
    }
}