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

public class electrician_properties extends AppCompatActivity {
    TextView tvGenerator,tvUPS;
    Button halfHourBtn_Electrician;
    CheckBox generator_CheckBox,UPSCheckBox;
    Button electricianPackage;

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
        generator_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    UPSCheckBox.setChecked(false);

                }
            }
        });
        UPSCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    generator_CheckBox.setChecked(false);

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
                startActivity(intent);
            }
        });
    }
}