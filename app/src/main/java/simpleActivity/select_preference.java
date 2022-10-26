package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mayd.R;
import com.example.mayd.sign_in_ForCustomer;

public class select_preference extends AppCompatActivity {
    Button btnCustomer, btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.select_preference);
        btnCustomer = findViewById(R.id.btnCustomerPreference);
        btnService = findViewById(R.id.btnServicesPreference);

        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_preference.this, sign_in_ForCustomer.class);
                startActivity(intent);

            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_preference.this, sign_in_for_service_provider.class);
                startActivity(intent);

            }
        });

    }
}