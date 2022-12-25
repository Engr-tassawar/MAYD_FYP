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

public class hvacr extends AppCompatActivity {
    TextView tv_gasRefilling,tv_AcNewInstallation,tv_AcReplacement,tv_Refrigerator;
    Button halfHourBtn_Hvacr;
    CheckBox gasRefilling_CheckBox,AcNewInstallation_CheckBox,AcReplacement_CheckBox,Refrigerator_CheckBox;
    Button HvacrPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hvacr);
        tv_gasRefilling=findViewById(R.id.tv_gasRefilling);
        tv_AcNewInstallation=findViewById(R.id.tv_AcNewInstallation);
        tv_AcReplacement=findViewById(R.id.tv_AcReplacement);
        tv_Refrigerator=findViewById(R.id.tv_Refrigerator);
        halfHourBtn_Hvacr=findViewById(R.id.halfHourBtn_Hvacr);
        gasRefilling_CheckBox=findViewById(R.id.gasRefilling_CheckBox);
        AcNewInstallation_CheckBox=findViewById(R.id.AcNewInstallation_CheckBox);
        AcReplacement_CheckBox=findViewById(R.id.AcReplacement_CheckBox);
        Refrigerator_CheckBox=findViewById(R.id.Refrigerator_CheckBox);
        HvacrPackage=findViewById(R.id.HvacrPackage);
        HvacrPackage.setEnabled(false);
        gasRefilling_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    AcNewInstallation_CheckBox.setChecked(false);
                    AcReplacement_CheckBox.setChecked(false);
                    Refrigerator_CheckBox.setChecked(false);
                    HvacrPackage.setEnabled(true);
                }
                else{
                    HvacrPackage.setEnabled(false);
                }
            }
        });
        AcNewInstallation_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gasRefilling_CheckBox.setChecked(false);
                    AcReplacement_CheckBox.setChecked(false);
                    Refrigerator_CheckBox.setChecked(false);
                    HvacrPackage.setEnabled(true);
                }
                else{
                    HvacrPackage.setEnabled(false);
                }
            }
        });
        AcReplacement_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gasRefilling_CheckBox.setChecked(false);
                    AcNewInstallation_CheckBox.setChecked(false);
                    Refrigerator_CheckBox.setChecked(false);
                    HvacrPackage.setEnabled(true);
                }
                else{
                    HvacrPackage.setEnabled(false);
                }
            }
        });
        Refrigerator_CheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gasRefilling_CheckBox.setChecked(false);
                    AcNewInstallation_CheckBox.setChecked(false);
                    AcReplacement_CheckBox.setChecked(false);
                    HvacrPackage.setEnabled(true);
                }
                else{
                    HvacrPackage.setEnabled(false);
                }
            }
        });
        halfHourBtn_Hvacr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hvacr.this, booking_schedule.class);
                startActivity(intent);
            }
        });
        HvacrPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hvacr.this, booking_schedule.class);
                startActivity(intent);
            }
        });
    }
}