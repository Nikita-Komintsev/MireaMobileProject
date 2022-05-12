package com.mirea.komintsev.mireaproject.ui.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.Notes;
import com.mirea.komintsev.mireaproject.ui.notes.db.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class NotesMainFragment extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fab_add_notes;

    private NotesListAdapter notesListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab_add_notes=view.findViewById(R.id.fab_add_notes);


        fab_add_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_notesMainFragment_to_notesTalkerFragment);

            }
        });

        recyclerView=view.findViewById(R.id.recycler_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        notesListAdapter = new NotesListAdapter(this.getContext());
        recyclerView.setAdapter(notesListAdapter);

        loadNotesList();
    }


    private void loadNotesList(){
        RoomDB database = RoomDB.getInstance(this.getContext());
        List<Notes> notesList =  database.mainDao().getAll();
        notesListAdapter.setNotesList(notesList);
    }

}