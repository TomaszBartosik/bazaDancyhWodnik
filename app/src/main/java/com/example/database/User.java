package com.example.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {


  public User(String data, String hour){
      this.data=data;
      this.hour=hour;
  }

  public User(){}


    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "date")
    private String data;
    @ColumnInfo(name = "hour")
    private String hour;

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getHour() {
        return hour;
    }
}
