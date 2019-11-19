package com.example.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class createUser extends AppCompatActivity {


    EditText inputData;
    EditText inputHour;
    private static final String TAG = "createUser";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        inputData = (EditText)findViewById(R.id.inputData);
        inputHour = (EditText)findViewById(R.id.inputHour);
    }

    public void addPosition(View view) {

        Log.d(TAG, "addPosition: ");

        // SAVE TO DATABASE


    }
}
