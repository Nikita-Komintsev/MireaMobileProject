package com.mirea.komintsev.mireaproject.ui.notes.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import java.util.List;

public class NotesRepository {
    private MainDAO mainDAO;
    private RoomDB roomDB;

    public NotesRepository(Application application){
        roomDB = RoomDB.getInstance(application);
        mainDAO = roomDB.mainDao();
    }


    public void deleteNote(final Notes notes){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                roomDB.mainDao().delete(notes);
                return null;
            }
        }.execute();
    }
}
