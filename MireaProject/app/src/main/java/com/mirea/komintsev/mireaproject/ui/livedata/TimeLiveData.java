package com.mirea.komintsev.mireaproject.ui.livedata;

import android.annotation.SuppressLint;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeLiveData {
    private static final MutableLiveData<Long> data = new MutableLiveData<>();
    static MutableLiveData<Long> getTime(){
        data.setValue(new Date().getTime());
        return data;
    }
    static void setTime(){
        data.setValue(new Date().getTime());
    }
    private static LiveData<String> getStringTime = Transformations.map(data, new Function<Long, String>() {
        @Override
        public String apply(Long input) {
            Calendar calendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            return df.format(calendar.getTime());
        }
    });

    static LiveData<String> getDate(){
        return getStringTime;
    }
}
