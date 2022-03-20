package com.mirea.komintsev.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        mainThread.setName("MireaThread");
        infoTextView.append("\nНовое имя потока: " + mainThread.getName());

    }

    public void onClick(View view) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int numberThread = counter++;
                Log.i("ThreadProject", "Запущен поток № " + numberThread);
                long endTime = System.currentTimeMillis() + 20 * 1000;

                while (System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (Exception e){
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток № " + numberThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void Count(View view) {
        EditText lessons = findViewById(R.id.editTextNumber);
        EditText days = findViewById(R.id.editTextNumber2);
        TextView resultText = findViewById(R.id.result);

        Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                float num1 = Integer.parseInt(lessons.getText().toString());
                float num2 = Integer.parseInt(days.getText().toString());
                float result = num1/num2;
                resultText.setText(Float.toString(result));
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}