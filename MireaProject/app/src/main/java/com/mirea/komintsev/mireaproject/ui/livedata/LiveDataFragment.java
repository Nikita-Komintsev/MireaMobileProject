package com.mirea.komintsev.mireaproject.ui.livedata;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirea.komintsev.mireaproject.R;

public class LiveDataFragment extends Fragment implements Observer<String> {
    private TextView dateTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_data, container, false);
        return view;
    }

    @SuppressLint("SetTextI18n")
    public void onChanged(@Nullable String s) {
        dateTextView.setText("" + s);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dateTextView = view.findViewById(R.id.dateTextView);
        TimeLiveData.getDate().observe(getViewLifecycleOwner(), this);
        Handler handler = new Handler();
        handler.postDelayed(TimeLiveData::setTime, 1000);
    }
}