package com.mirea.komintsev.mireaproject.ui.notesV2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.Notes;
import com.mirea.komintsev.mireaproject.ui.notes.db.RoomDB;

import java.util.List;


public class NotesV2Fragment extends Fragment {
    private NotesViewModel notesViewModel;
    FloatingActionButton fab_add_notes;
    Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_v2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment = new NotesV2Fragment();

        fab_add_notes=view.findViewById(R.id.fab_add_notes_v2);


        fab_add_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_notesV2Fragment_to_addNoteV2Fragment);

            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_v2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        notesViewModel.getAllNotes().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                notesViewModel.delete(adapter.getNoteAt(viewHolder.getAbsoluteAdapterPosition()));
                Toast.makeText(getContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

//        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Note note) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("id", Integer.parseInt(String.valueOf(note.getId())));
//                bundle.putString("title", String.valueOf(note.getTitle()));
//                bundle.putString("description", String.valueOf(note.getDescription()));
//                bundle.putInt("priority", Integer.parseInt(String.valueOf(note.getPriority())));
//                fragment.setArguments(bundle);
//
//                Navigation.findNavController(view).navigate(R.id.action_notesV2Fragment_to_addNoteV2Fragment);
//
//            }
//        });
    }

}