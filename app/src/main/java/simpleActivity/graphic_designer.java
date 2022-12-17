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

public class graphic_designer extends AppCompatActivity {
    TextView tv_logoDesign,tv_monthlyPost;
    Button halfHourBtn_Graphic;
    CheckBox logoDesign_CheckBox,monthlyPost_CheckBox;
    Button graphicPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_designer);

        halfHourBtn_Graphic=findViewById(R.id.halfHourBtn_Graphic);
        tv_logoDesign=findViewById(R.id.tv_logoDesign);
        tv_monthlyPost=findViewById(R.id.tv_monthlyPost);
        logoDesign_CheckBox=findViewById(R.id.logoDesign_CheckBox);
        monthlyPost_CheckBox=findViewById(R.id.monthlyPost_CheckBox);
        graphicPackage=findViewById(R.id.graphicPackage);

        logoDesign_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    monthlyPost_CheckBox.setChecked(false);

                }
            }
        });
        monthlyPost_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    logoDesign_CheckBox.setChecked(false);

                }
            }
        });
        halfHourBtn_Graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(graphic_designer.this, booking_schedule.class);
                startActivity(intent);
            }
        });
        graphicPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(graphic_designer.this, booking_schedule.class);
                startActivity(intent);
            }
        });
    }
}