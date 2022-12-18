package simpleActivity;

import static Model.DriverClass.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mayd.R;

import Model.BookingDetail;
import Model.DriverClass;
import Model.Order;
import Utils.Common;

public class booking_details extends AppCompatActivity {
    Button btn_homeBookingDetail;
    TextView priceDetail,tvServiceDetail,packegDetail,bookingDetail_address,bookingDetail_time,bookingDetail_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        Order order = Common.getOrderObject(booking_details.this);
        priceDetail=findViewById(R.id.priceDetail);
        btn_homeBookingDetail=findViewById(R.id.btn_homeBookingDetail);
        tvServiceDetail=findViewById(R.id.tvServiceDetail);
        bookingDetail_address=findViewById(R.id.bookingDetail_address);
        bookingDetail_time=findViewById(R.id.bookingDetail_time);
        bookingDetail_date=findViewById(R.id.bookingDetail_date);
        packegDetail=findViewById(R.id.packegDetail);
        btn_homeBookingDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_details.this, home1.class);
                startActivity(intent);
            }
        });
        String selectDate=getIntent().getStringExtra("Date");
        String selectTime=getIntent().getStringExtra("Time");
        String selectAddress=getIntent().getStringExtra("Address");
        bookingDetail_date.setText(selectDate);
        bookingDetail_time.setText(selectTime);
        bookingDetail_address.setText(selectAddress);

        //tvServiceDetail.setText(driverType);
        //priceDetail.setText(price);

    }
}