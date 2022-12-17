package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mayd.R;

public class painter extends AppCompatActivity {
    TextView tv_painterPerDay;
    Button halfHourBtn_Painter;
    CheckBox painterPerDay_CheckBox;
    Button painterPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);
        tv_painterPerDay=findViewById(R.id.tv_painterPerDay);
        halfHourBtn_Painter=findViewById(R.id.halfHourBtn_Painter);
        painterPerDay_CheckBox=findViewById(R.id.painterPerDay_CheckBox);
        painterPackage=findViewById(R.id.painterPackage);
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
                startActivity(intent);
            }
        });
    }
}