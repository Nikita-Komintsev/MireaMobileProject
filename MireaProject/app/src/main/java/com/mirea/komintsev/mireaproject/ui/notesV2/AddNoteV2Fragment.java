package com.mirea.komintsev.mireaproject.ui.notesV2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.material.internal.EdgeToEdgeUtils;
import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.RoomDB;

import java.util.List;

public class AddNoteV2Fragment extends Fragment {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    Button saveButton;

    private NotesViewModel notesViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_note_v2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextTitle = view.findViewById(R.id.edit_text_title);
        editTextDescription = view.findViewById(R.id.edit_text_description);
        numberPickerPriority = view.findViewById(R.id.number_picker_priority);
        saveButton = view.findViewById(R.id.save_note_button_v2);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
                Navigation.findNavController(view).navigate(R.id.action_addNoteV2Fragment_to_notesV2Fragment);
            }
        });


        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        NoteAdapter adapter = new NoteAdapter();

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        notesViewModel.getAllNotes().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });


    }

    private void saveNote() {
        String title  = editTextTitle.getText().toString();
        String description  = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Note note = new Note(title, description, priority);
        notesViewModel.insert(note);
        Toast.makeText(getContext(), "Note Save", Toast.LENGTH_SHORT).show();
    }
}