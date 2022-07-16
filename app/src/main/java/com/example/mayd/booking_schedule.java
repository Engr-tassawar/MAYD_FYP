package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class booking_schedule extends AppCompatActivity {
    TextInputEditText edtSelectDate;
    int year;
    int day;
    int month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_schedule);
        edtSelectDate=findViewById(R.id.edtSelectDate);

        Calendar calender = Calendar.getInstance();
        edtSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(booking_schedule.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edtSelectDate.setText(SimpleDateFormat.getDateInstance().format(calender.getTime()));


                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}