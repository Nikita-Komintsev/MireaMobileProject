package com.mirea.komintsev.mireaproject.ui.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.Notes;
import com.mirea.komintsev.mireaproject.ui.notes.db.RoomDB;

public class NotesTalkerFragment extends Fragment {
    EditText editText_title,editText_notes;
    Button saveButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_talker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText_title=view.findViewById(R.id.editText_title);
        editText_notes=view.findViewById(R.id.editText_notes);
        saveButton= view.findViewById(R.id.saveNoteButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewNote(editText_title.getText().toString(), editText_notes.getText().toString());
            }
        });
    }

    private void saveNewNote(String editText_title, String editText_notes){
        RoomDB database = RoomDB.getInstance(this.getContext());

        Notes note = new Notes();
        note.title = editText_title;
        note.description = editText_notes;
        database.mainDao().insert(note);

    }
}