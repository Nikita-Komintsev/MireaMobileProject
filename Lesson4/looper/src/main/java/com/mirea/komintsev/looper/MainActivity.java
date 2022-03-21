package com.mirea.komintsev.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private MyLooper myLooper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View view) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "Student");
        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}