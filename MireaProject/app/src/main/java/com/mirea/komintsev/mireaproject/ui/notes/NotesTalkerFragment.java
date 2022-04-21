package com.mirea.komintsev.mireaproject.ui.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mirea.komintsev.mireaproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTalkerFragment extends Fragment {
    EditText editText_title,editText_notes;
    ImageView imageView_save;
    Notes notes;

    public NotesTalkerFragment() {
        // Required empty public constructor
    }

    public static NotesTalkerFragment newInstance(String param1, String param2) {
        NotesTalkerFragment fragment = new NotesTalkerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
        imageView_save=view.findViewById(R.id.imageView_save);
        editText_title=view.findViewById(R.id.editText_title);
        editText_notes=view.findViewById(R.id.editText_notes);

        notes = new Notes();

        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=editText_title.getText().toString();
                String description=editText_notes.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(getActivity(),"Please add some text to the note", Toast.LENGTH_SHORT).show();
                    return;
                }
                //устанавливаем аттрибуты
                notes.setTitle(title);
                notes.setNotes(description);

                //взаимодействие между различными объектами activity
                Intent intent = new Intent();
                intent.putExtra("note", notes); // передается только сериализуемый объект
//                setResult(Activity.RESULT_OK, intent);
//                finish();
            }
        });
    }
}