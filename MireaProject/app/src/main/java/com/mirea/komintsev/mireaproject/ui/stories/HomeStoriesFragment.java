package com.mirea.komintsev.mireaproject.ui.stories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirea.komintsev.mireaproject.MainActivity;
import com.mirea.komintsev.mireaproject.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeStoriesFragment extends Fragment {
    FloatingActionButton fab_add;

    RecyclerView recyclerView;
    List<Stories> stories;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stories_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        stories = getListData();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(stories);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab_add = getView().findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_stories_to_storiesFragment);

            }
        });
        make_stories();

    }
    private void make_stories() {
        Toast.makeText(getContext(), "make_stories", Toast.LENGTH_SHORT).show();
    }



    private List<Stories> getListData(){
        List<Stories> list = new ArrayList<>();
        Stories stories1 = new Stories("text1","stories_1");
//        Stories stories2 = new Stories("text2","stories_2");
//        Stories stories3 = new Stories("text3","stories_3");
//        Stories stories4 = new Stories("text4","stories_4");
//        Stories stories1 = new Stories("text1");
//        Stories stories2 = new Stories("text2");
//        Stories stories3 = new Stories("text3");
//        Stories stories4 = new Stories("text4");

        list.add(stories1);
//        list.add(stories2);
//        list.add(stories3);
//        list.add(stories4);

        return  list;
    }

}