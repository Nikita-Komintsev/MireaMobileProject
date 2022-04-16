package com.mirea.komintsev.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        // получение доступа к создайнной ViewModel
        ProgressViewModel viewModel = new ViewModelProvider(this).get(ProgressViewModel.class);
//                ViewModelProviders.of(this).get(ProgressViewModel.class);
        viewModel.getProgressState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isVisibleProgressBar) {
                if (isVisibleProgressBar) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        viewModel.showProgress();
    }
}