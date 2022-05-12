package com.mirea.komintsev.mireaproject.ui.notes.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface MainDAO {
    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Insert
    void insert(Notes... notes);

    @Delete
    void delete(Notes note);

}
