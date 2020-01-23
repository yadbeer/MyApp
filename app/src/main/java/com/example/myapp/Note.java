package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table")
public class Note {
    private String title ;
    private String desc ;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public Note(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }
}
