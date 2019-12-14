package com.example.database;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class createUser extends AppCompatActivity {


    public TextView inputData;
    public TextView inputHour;
    public AppDatabase db;
    public String date;
    public String hour;


    private static final String TAG = "createUser";




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        inputData = (TextView)findViewById(R.id.inputData);
        inputHour = (TextView)findViewById(R.id.inputHour);


       db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production").allowMainThreadQueries().build();

    }


    public void addPosition(View view) {

        Log.d(TAG, "addPosition: "+"data  "+inputData.getText()+"godzina    "+inputHour.getText());

        // SAVE TO DATABASE
         db.userDAO().instertAll(new User(date,hour));
         startActivity(new Intent(createUser.this, MainActivity.class));




    }



    public void datePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        final int Year = calendar.get(Calendar.YEAR);
        final int Month = calendar.get(Calendar.MONTH);
        final int Day = calendar.get(Calendar.DAY_OF_MONTH);



        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String datea = sdf.format(new Date());


                date= year+"/"+(month+1)+"/"+dayOfMonth;
                inputData.setText(datea);
            }
        },Year,Month,Day);
        datePickerDialog.show();

    }


    public void timePicker(View view) {
        Calendar time = Calendar.getInstance();
        final int Hour= time.get(Calendar.HOUR);
        final int Minute=time.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
             if(Minute<10){
                 hour = hourOfDay+":0"+minute;
             }

             else {
                 hour = hourOfDay+":"+minute;
             }

            inputHour.setText(hour);
            }
        },Hour, Minute,true);
        timePickerDialog.show();

    }
}
