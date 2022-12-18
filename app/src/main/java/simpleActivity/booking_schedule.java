package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.mayd.R;
import com.example.mayd.select_service_provider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Locale;

import Model.DriverClass;
import Model.Order;

public class booking_schedule extends AppCompatActivity {

    Button btn_proceed_schedule;
    TextInputEditText edtSelectDate, edtSelectTime, edtEnterAddress, edtDescription;
    TimePickerDialog timePickerDialog;
    FirebaseAuth auth;
    int year;
    int day;
    int month;
    int Hour;
    int Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_schedule);

        Intent intent = getIntent();
        Order order = (Order) intent.getExtras().getSerializable("orderObject");

        auth = FirebaseAuth.getInstance();

        btn_proceed_schedule = findViewById(R.id.btn_proceed_schedule);
        edtSelectDate = findViewById(R.id.edtSelectDate);
        edtSelectTime = findViewById(R.id.edtSelectTime);
        edtEnterAddress = findViewById(R.id.edtEnterAddress);
        edtDescription = findViewById(R.id.edtDescription);
        btn_proceed_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectDate = edtSelectDate.getText().toString().trim();
                String selectTime = edtSelectTime.getText().toString().trim();
                String selectAddress = edtEnterAddress.getText().toString().trim();
                String selectDescription = edtDescription.getText().toString().trim();


                if (selectDate.isEmpty()) {
                    edtSelectDate.setError("Please select date");
                    edtSelectDate.requestFocus();
                    return;
                }
                if (selectTime.isEmpty()) {
                    edtSelectTime.setError("Please select time");
                    edtSelectTime.requestFocus();
                    return;
                }
                if (selectAddress.isEmpty()) {
                    edtEnterAddress.setError("Please enter your address");
                    edtEnterAddress.requestFocus();
                    return;
                }
                if (selectDescription.isEmpty()) {
                    edtDescription.setError("Please enter description");
                    edtDescription.requestFocus();
                    return;
                } else {
                    /*BookingDetail bookingDetail=new BookingDetail(selectDate,selectTime,selectAddress,selectDescription);
                    FirebaseDatabase.getInstance().getReference().child("CustomerUsers").child(auth.getUid())
                            .setValue(bookingDetail);*/

                    DriverClass driver = (DriverClass) order.service;

                    order.date = selectDate;
                    order.time = selectTime;
                    order.address = selectAddress;
                    order.price = driver.price;
                    order.description = selectDescription;

                    Intent intent = new Intent(booking_schedule.this, select_service_provider.class);
                    intent.putExtra("orderObject", order);
                    startActivity(intent);
                    finish();
                }
            }
        });

        edtSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calender = Calendar.getInstance();
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(booking_schedule.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        edtSelectDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        edtSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                        Hour = selectHour;
                        Minute = selectMinute;
                        edtSelectTime.setText(String.format(Locale.getDefault(), "%02d:%2d", Hour, Minute));

                    }

                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(booking_schedule.this, onTimeSetListener, Hour, Minute, true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

    }
}