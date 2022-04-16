package com.mirea.komintsev.laboratory1;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarkersViewModel extends ViewModel {
    private static MutableLiveData<Boolean> isShowMarkers = new MutableLiveData<>();

    void showProgress() {
        isShowMarkers.postValue(true);

    }
    // Возвращает состояние прогресс?
    MutableLiveData<Boolean> getProgressState() {
        return isShowMarkers;
    }
}
