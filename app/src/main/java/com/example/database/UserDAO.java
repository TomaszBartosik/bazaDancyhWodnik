package com.example.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Insert
    void instertAll(User... users);
}
