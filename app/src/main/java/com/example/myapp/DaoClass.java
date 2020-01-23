package com.example.myapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Query("SELECT * FROM 'table'")
    LiveData<List<Note>> getAllNotes();
}
