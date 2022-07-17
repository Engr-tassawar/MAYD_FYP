package com.example.mayd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class booking_schedule extends AppCompatActivity {
    TextInputEditText edtSelectDate,edtSelectTime;
    TimePickerDialog timePickerDialog;
    int year;
    int day;
    int month;
    int Hour;
    int Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_schedule);
        edtSelectDate=findViewById(R.id.edtSelectDate);
        edtSelectTime=findViewById(R.id.edtSelectTime);
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
        edtSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener= new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                        Hour = selectHour;
                        Minute=selectMinute;
                        edtSelectTime.setText(String.format(Locale.getDefault(),"%02d:%2d",Hour,Minute));

                    }

                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(booking_schedule.this,onTimeSetListener,Hour,Minute,true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

    }
}