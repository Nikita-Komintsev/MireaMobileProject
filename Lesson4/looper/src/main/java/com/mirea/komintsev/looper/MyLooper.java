package com.mirea.komintsev.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

public class MyLooper extends Thread{
    private int number = 0;
    public android.os.Handler handler;
    @SuppressLint("HandlerLeak")
  @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();

        handler = new Handler(){
            public void handleMessage(Message msg){
            Log.d("MyLooper", number + ": "+ msg.getData().getString("KEY"));
            number++;
            }
        };
        Looper.loop();
    }

}
