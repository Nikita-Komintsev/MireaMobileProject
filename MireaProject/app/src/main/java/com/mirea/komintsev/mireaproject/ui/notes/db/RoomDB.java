package com.mirea.komintsev.mireaproject.ui.notes.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities= Notes.class, version = 2, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB INSTANCE;
    private static String DATABASE_NAME="NoteApp";

    public abstract MainDAO mainDao();

    public static RoomDB getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
