package com.mirea.komintsev.mireaproject.ui.stories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mirea.komintsev.mireaproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StoriesFragment extends Fragment {
    Random random;
    Integer[] masPhoto = {R.drawable.stories_1, R.drawable.stories_2, R.drawable.stories_3, R.drawable.stories_4};
    Button makePhotoStories;
    Button buttonSave;
    ImageView imageViewStories;
    TextView text;
    int pickedPhoto;
    List<Stories> stories;
    List<Stories> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "There you make stories", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        makePhotoStories = getActivity().findViewById(R.id.buttonMakePhoto);
        imageViewStories = getActivity().findViewById(R.id.imageViewStories);
        text = getActivity().findViewById(R.id.text);
        buttonSave = getActivity().findViewById(R.id.buttonSave);

        random = new Random();
        makePhotoStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickedPhoto = random.nextInt(masPhoto.length);
                imageViewStories.setImageResource(masPhoto[pickedPhoto]);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = text.getText().toString();
                Stories stories = new Stories(s,"stories_1");
                list.add(stories);
            }
        });
    }
}