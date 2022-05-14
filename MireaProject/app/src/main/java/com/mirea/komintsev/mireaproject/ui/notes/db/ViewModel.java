package com.mirea.komintsev.mireaproject.ui.notes.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class ViewModel extends AndroidViewModel {
    NotesRepository notesRepository;

    public ViewModel(@NonNull Application application) {
        super(application);
        notesRepository = new NotesRepository(application);

    }

    public void deleteNote(Notes notes){
        notesRepository.deleteNote(notes);
    }
}
