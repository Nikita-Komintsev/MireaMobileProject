package com.mirea.komintsev.mireaproject.ui.stories;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mirea.komintsev.mireaproject.MainActivity;
import com.mirea.komintsev.mireaproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StoriesFragment extends Fragment {
    ImageView imageViewStories;
    TextView text;
    Button buttonSave;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);

        text = view.findViewById(R.id.storiesText);

        buttonSave = view.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textString = ((TextView)view.findViewById(R.id.storiesText)).getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString("key",textString);
//                HomeStoriesFragment fragment = new HomeStoriesFragment();
//                fragment.setArguments(bundle);
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.nav_view, fragment)
//                        .commit();
            }
        });



        return view;
    }

}