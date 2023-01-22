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
import Model.ServiceTypes;
import Utils.Common;

public class painter extends AppCompatActivity {
    TextView tv_painterPerDay;
    CheckBox painterPerDay_CheckBox;
    CheckBox painterPerMonth_CheckBox;
    Button painterPackage;
    Order order= new Order();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);
        tv_painterPerDay=findViewById(R.id.tv_painterPerDay);
        painterPerDay_CheckBox=findViewById(R.id.painterPerDay_CheckBox);
        painterPerMonth_CheckBox=findViewById(R.id.painterPerMonth_CheckBox);
        painterPackage=findViewById(R.id.painterPackage);
        order.ServiceDescription = ServiceTypes.Painter;

        painterPerDay_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    painterPerMonth_CheckBox.setChecked(false);
                    order.ServiceDescription = "Painter Per Day Charges (Sketch etc.)";
                    order.price="2000";
                    painterPackage.setEnabled(true);
                }
                else{
                    painterPackage.setEnabled(false);
                }
            }
        });

        painterPerMonth_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    painterPerDay_CheckBox.setChecked(false);
                    order.ServiceDescription = "Painting Home Tuition (Monthly)";
                    order.price="25000";
                    painterPackage.setEnabled(true);
                }
                else{
                    painterPackage.setEnabled(false);
                }
            }
        });

        painterPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(painter.this, booking_schedule.class);
                Common.sendOrderObjectToNextActivity(intent,order);
                startActivity(intent);
                finish();
            }
            
        });
    }
}