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

public class house_keeping extends AppCompatActivity {
    TextView tv_houseKeeping_allRoundMonthly,tv_basicMonthly,tv_officeCleaner,tv_fulTime,tv_laundry;
    Button halfHourBtn_houseKeeping;
    CheckBox houseKeeping_allRoundMonthly_CheckBox,laundry_CheckBox,fulTime_CheckBox,basicMonthly_CheckBox,officeCleaner_CheckBox;
    Button houseKeepingPackage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping);
        halfHourBtn_houseKeeping=findViewById(R.id.halfHourBtn_houseKeeping);

        tv_houseKeeping_allRoundMonthly=findViewById(R.id.tv_houseKeeping_allRoundMonthly);
        tv_basicMonthly=findViewById(R.id.tv_basicMonthly);
        tv_officeCleaner=findViewById(R.id.tv_officeCleaner);
        tv_fulTime=findViewById(R.id.tv_fulTime);
        tv_laundry=findViewById(R.id.tv_laundry);

        houseKeeping_allRoundMonthly_CheckBox=findViewById(R.id.houseKeeping_allRoundMonthly_CheckBox);
        basicMonthly_CheckBox=findViewById(R.id.basicMonthly_CheckBox);
        officeCleaner_CheckBox=findViewById(R.id.officeCleaner_CheckBox);
        fulTime_CheckBox=findViewById(R.id.fulTime_CheckBox);
        laundry_CheckBox=findViewById(R.id.laundry_CheckBox);

        houseKeepingPackage=findViewById(R.id.houseKeepingPackage);
        houseKeeping_allRoundMonthly_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    basicMonthly_CheckBox.setChecked(false);
                    officeCleaner_CheckBox.setChecked(false);
                    fulTime_CheckBox.setChecked(false);
                    laundry_CheckBox.setChecked(false);
                }
            }
        });
        basicMonthly_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    officeCleaner_CheckBox.setChecked(false);
                    fulTime_CheckBox.setChecked(false);
                    laundry_CheckBox.setChecked(false);
                    houseKeeping_allRoundMonthly_CheckBox.setChecked(false);
                }
            }
        });
        officeCleaner_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fulTime_CheckBox.setChecked(false);
                    laundry_CheckBox.setChecked(false);
                    houseKeeping_allRoundMonthly_CheckBox.setChecked(false);
                    basicMonthly_CheckBox.setChecked(false);
                }
            }
        });
        fulTime_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    laundry_CheckBox.setChecked(false);
                    houseKeeping_allRoundMonthly_CheckBox.setChecked(false);
                    basicMonthly_CheckBox.setChecked(false);
                    officeCleaner_CheckBox.setChecked(false);
                }
            }
        });
        laundry_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    fulTime_CheckBox.setChecked(false);
                    houseKeeping_allRoundMonthly_CheckBox.setChecked(false);
                    basicMonthly_CheckBox.setChecked(false);
                    officeCleaner_CheckBox.setChecked(false);
                }
            }
        });
       halfHourBtn_houseKeeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(house_keeping.this, booking_schedule.class);
                startActivity(intent);
            }
        });
       houseKeepingPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(house_keeping.this, booking_schedule.class);
                startActivity(intent);
            }
        });
    }
}