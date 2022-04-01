package com.mirea.komintsev.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText editTextFileName;
    private EditText editForText;
    private SharedPreferences preferences;
    final String SAVED_TEXT = "saved_text";
    String fileName;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = findViewById(R.id.editTextFileName);
        editForText = findViewById(R.id.editForText);
        preferences = getPreferences(MODE_PRIVATE);
    }

    public void onSaveText(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        // Сохранение значения по ключу SAVED_TEXT
        editor.putString(SAVED_TEXT, editForText.getText().toString());
        editor.apply();

        fileName = editTextFileName.getText().toString();
        text = editForText.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
    }

    public void onLoadText(View view) {
        // Загрузка значения по ключу SAVED_TEXT
        String text = preferences.getString(SAVED_TEXT, "Empty");
        editForText.setText(text);
    }
}