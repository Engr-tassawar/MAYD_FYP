package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.mayd.R;

public class plumber_properties extends AppCompatActivity {
    Button halfHourBtn_Plumber;
    CheckBox bathroomCheckBox,gasLineIronCheckBox,gasLinePlasticCheckBox,drainOpenerCheckBox;
    Button plumberPackage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_properties);
        halfHourBtn_Plumber=findViewById(R.id.halfHourBtn_Plumber);
        bathroomCheckBox=findViewById(R.id.bathroomCheckBox);
        gasLineIronCheckBox=findViewById(R.id.gasLineIronCheckBox);
        gasLinePlasticCheckBox=findViewById(R.id.gasLinePlasticCheckbox);
        drainOpenerCheckBox=findViewById(R.id.drainOpenerCheckBox);
        plumberPackage=findViewById(R.id.plumberPackage);
        halfHourBtn_Plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plumber_properties.this, book_your_service.class);
                startActivity(intent);
            }
        });
        plumberPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plumber_properties.this, book_your_service.class);
                startActivity(intent);
            }
        });
    }
}