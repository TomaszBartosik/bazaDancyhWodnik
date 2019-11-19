package com.example.database;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
//    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);

  //      users = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            User user = new User("zxc","ccc");
//            users.add(user);
//            Log.d(TAG, "onCreate: "+users.get(i));
//        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production").allowMainThreadQueries().build();

        List<User> users = db.userDAO().getAllUser();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter) ;



    }

    public void createPosition(View view) {

        Intent intent = new Intent(this,createUser.class);
        startActivity(intent);

    }
}
