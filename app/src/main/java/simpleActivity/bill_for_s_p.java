package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mayd.R;

import Model.Order;
import Utils.Common;

public class bill_for_s_p extends AppCompatActivity {
    Button GotoHome;
    TextView Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_for_sp);
        GotoHome = findViewById(R.id.show_price_btn);
        Price = findViewById(R.id.show_price);

        Order order = Common.getOrderObject(bill_for_s_p.this);
        Price.setText("Total: " + order.price + " /-");
        GotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}

