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
    Button buttonSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stories_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        stories = getListData();
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(), stories));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab_add = view.findViewById(R.id.fab_add);
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
        Stories stories1 = new Stories("Подпись к фото","stories_1");
        Stories stories2 = new Stories("Подпись к фото","stories_2");
        Stories stories3 = new Stories("Подпись к фото","stories_3");

        list.add(stories1);
        list.add(stories2);
        list.add(stories3);

        return  list;
    }

}