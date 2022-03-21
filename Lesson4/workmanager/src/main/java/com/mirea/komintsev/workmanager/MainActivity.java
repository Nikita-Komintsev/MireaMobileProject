package com.mirea.komintsev.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class).build();
            WorkManager
                    .getInstance(this)
                    .enqueue(uploadWorkRequest);
        }
        else {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();
        }
    }
}