package com.example.myapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repo {
    private DaoClass noteDao;
    private LiveData<List<Note>> allNotes;

    public Repo(Application application){
        DB database = DB.getInstance(application);
        noteDao = database.daoClass();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private DaoClass noteDao;

        private InsertNoteAsyncTask(DaoClass dao){
            this.noteDao = dao;
        }
        @Override
        protected Void doInBackground(Note... notes){
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>{
        private DaoClass noteDao;

        private UpdateNoteAsyncTask(DaoClass dao){
            this.noteDao = dao;
        }
        @Override
        protected Void doInBackground(Note... notes){
            noteDao.update(notes[0]);
            return null;
        }
    }


}
