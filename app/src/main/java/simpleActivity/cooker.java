package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mayd.R;

public class cooker extends AppCompatActivity {
    TextView tv_monthlyCook,tv_fullDay,tv_cookHelper_houseKeeping,tv_partTime;
    Button halfHourBtn_Cook;
    CheckBox monthlyCook_CheckBox,fullDay_CheckBox,cookHelper_houseKeeping_CheckBox,partTime_CheckBox;
    Button cookPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooker);
        halfHourBtn_Cook=findViewById(R.id.halfHourBtn_Cook);
        monthlyCook_CheckBox=findViewById(R.id.monthlyCook_CheckBox);
        fullDay_CheckBox=findViewById(R.id.fullDay_CheckBox);
        cookHelper_houseKeeping_CheckBox=findViewById(R.id.cookHelper_houseKeeping_CheckBox);
        partTime_CheckBox=findViewById(R.id.partTime_CheckBox);
        cookPackage=findViewById(R.id.cookPackage);
        tv_monthlyCook=findViewById(R.id.tv_monthlyCook);
        tv_fullDay=findViewById(R.id.tv_fullDay);
        tv_cookHelper_houseKeeping=findViewById(R.id.tv_cookHelper_houseKeeping);
        tv_partTime=findViewById(R.id.tv_partTime);
        halfHourBtn_Cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cooker.this, book_your_service.class);
                startActivity(intent);
            }
        });
        cookPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cooker.this, book_your_service.class);
                startActivity(intent);
            }
        });
    }
}