package com.mirea.komintsev.mireaproject.ui.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.mirea.komintsev.mireaproject.ui.player.PlayerService;

import com.mirea.komintsev.mireaproject.MainActivity;
import com.mirea.komintsev.mireaproject.R;

public class MusicPlayer extends Fragment {
    // music player
    Button playButton;
    boolean musicPlay = false;

    public MusicPlayer() {

    }

    public static MusicPlayer newInstance(String param1, String param2) {
        MusicPlayer fragment = new MusicPlayer();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        playButton = view.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayOrStopMusic(view);
            }
        });
        return view;
    }


    // Music Player
    public void onClickPlayMusic(View view) {
        getActivity().startService(
                new Intent(getActivity(), PlayerService.class));
    }
    public void onClickStopMusic(View view) {
        getActivity().stopService(
                new Intent(getActivity(), PlayerService.class));
    }
    public  void  PlayOrStopMusic(View view){
        if (!musicPlay){
            onClickPlayMusic(view);
            musicPlay = true;
            playButton.setText("Stop");
        }
        else{
            onClickStopMusic(view);
            musicPlay = false;
            playButton.setText("Play");
        }
    }


}