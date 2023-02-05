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

public class graphic_designer extends AppCompatActivity {
    TextView tv_logoDesign,tv_monthlyPost;
    CheckBox logoDesign_CheckBox,monthlyPost_CheckBox;
    Button graphicPackage;
    Order order= new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_designer);

        tv_logoDesign=findViewById(R.id.tv_logoDesign);
        tv_monthlyPost=findViewById(R.id.tv_monthlyPost);
        logoDesign_CheckBox=findViewById(R.id.logoDesign_CheckBox);
        monthlyPost_CheckBox=findViewById(R.id.monthlyPost_CheckBox);
        graphicPackage=findViewById(R.id.graphicPackage);

        order.ServiceProviderType = ServiceTypes.Graphics;
        Toolbar toolbar=findViewById(R.id.toolbar_graphicDesigner);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Graphic Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        logoDesign_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    monthlyPost_CheckBox.setChecked(false);
                    order.ServiceDescription = "Logo Design";
                    order.price="1000";
                    graphicPackage.setEnabled(true);
                }
                else{
                    graphicPackage.setEnabled(false);
                }
            }
        });
        monthlyPost_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    logoDesign_CheckBox.setChecked(false);
                    order.ServiceDescription = "Monthly Posts Design";
                    order.price="15000";
                    graphicPackage.setEnabled(true);
                }
                else{
                    graphicPackage.setEnabled(false);
                }
            }
        });

        graphicPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(graphic_designer.this, booking_schedule.class);

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