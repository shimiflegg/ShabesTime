package com.shimi.shabestime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class datetimefromack2 extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
      {
    Button btnpick ;
    TextView tv_result;
    int day,month,year,hour,minuth;

    int dayfinel,monthFinal,yearFinal,hourFinal,minuthfinal;
    boolean is24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetimefromack2);
        btnpick=(Button)findViewById(R.id.btnpick);
        tv_result=(TextView)findViewById(R.id.tv_result);
        btnpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c= Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog datePickerDialog=new DatePickerDialog(datetimefromack2.this,datetimefromack2.this,
                       day,month,year);
                datePickerDialog.show();


            }
        });




    }

          @Override
          public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

              yearFinal = year;
              monthFinal = month + 1;
              dayOfMonth = dayOfMonth;
              Calendar c=Calendar.getInstance();
              hour=c.get(Calendar.HOUR_OF_DAY);
              minuth=c.get(Calendar.MINUTE);
              TimePickerDialog timePickerDialog = new TimePickerDialog
                      (datetimefromack2.this,datetimefromack2.this,hour,minuth,is24 );
             // timePickerDialog.show();
          }
          @Override
          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
             hourFinal = hourOfDay;
             monthFinal = minute;
             tv_result.setText("year:" + yearFinal + "\n" +
                     "month:" + monthFinal + "\n" +
                     "day:" + dayfinel + "\n" +
                     "hour:" + hourFinal + "\n" +
                     "minute:" + minuthfinal );
          }
      }
