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

public class painter extends AppCompatActivity {
    TextView tv_painterPerDay;
    Button halfHourBtn_Painter;
    CheckBox painterPerDay_CheckBox;
    Button painterPackage;
    Order order= new Order();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);
        tv_painterPerDay=findViewById(R.id.tv_painterPerDay);
        halfHourBtn_Painter=findViewById(R.id.halfHourBtn_Painter);
        painterPerDay_CheckBox=findViewById(R.id.painterPerDay_CheckBox);
        painterPackage=findViewById(R.id.painterPackage);
        painterPerDay_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    order.ServiceProviderType = "Painter Per Day Charges";
                    order.price="2000";
                    painterPackage.setEnabled(true);
                }
                else{
                    painterPackage.setEnabled(false);
                }
            }
        });
        halfHourBtn_Painter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(painter.this, booking_schedule.class);
                startActivity(intent);
            }
        });
        painterPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(painter.this, booking_schedule.class);
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