package com.example.database;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);

        users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add("TOM # "+i);
            Log.d(TAG, "onCreate: "+users.get(i));
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);   //25:34
        recyclerView.setAdapter(adapter) ;

    }

    public void createPosition(View view) {

        Intent intent = new Intent(this,createUser.class);
        startActivity(intent);
    }
}
