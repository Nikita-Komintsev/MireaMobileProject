package com.mirea.komintsev.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.os.Handler;

import java.util.concurrent.TimeUnit;

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
        bundle.putString("KEY", "21 Student");
        msg.setData(bundle);
        try {
            TimeUnit.SECONDS.sleep(21);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}