package com.mirea.komintsev.mireaproject.ui.notes;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Notes> selected = new MutableLiveData<Notes>();
    public void select(Notes notes) {
        selected.setValue(notes);
    }
    public LiveData<Notes> getSelected() {
        return selected;
    }
}
