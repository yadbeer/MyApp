package com.example.myapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1)
public abstract class DB extends RoomDatabase {
    private static DB instance;
    public abstract DaoClass daoClass();
    public static synchronized DB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DB.class, "DB").build();
        }
        return instance;
    }
}
