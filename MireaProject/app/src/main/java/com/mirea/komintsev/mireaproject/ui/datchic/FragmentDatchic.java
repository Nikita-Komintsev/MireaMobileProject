package com.mirea.komintsev.mireaproject.ui.datchic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirea.komintsev.mireaproject.MainActivity;
import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.databinding.FragmentHomeBinding;

public class FragmentDatchic extends Fragment implements SensorEventListener{
    private Activity mActivity;
    private FragmentHomeBinding binding;

    private TextView azimuthTextView;
    private TextView pitchTextView;
    private TextView rollTextView;
    private TextView pressureTextView;
    private TextView temperatureTextView;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor pressureSensor;
    private Sensor temperatureSensor;

    public FragmentDatchic() {
        // Required empty public constructor
    }

    public static FragmentDatchic newInstance(String param1, String param2) {
        FragmentDatchic fragment = new FragmentDatchic();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        pressureSensor =  sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        temperatureSensor =  sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datchic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        azimuthTextView = getView().findViewById(R.id.textViewAzimuth);
        pitchTextView = getView().findViewById(R.id.textViewPitch);
        rollTextView = getView().findViewById(R.id.textViewRoll);
        pressureTextView = getView().findViewById(R.id.textViewPressure);
        temperatureTextView = getView().findViewById(R.id.textViewTemperature);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, pressureSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, temperatureSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float valueAzimuth = event.values[0];
            float valuePitch = event.values[1];
            float valueRoll = event.values[2];
            azimuthTextView.setText("Azimuth: " + valueAzimuth);
            pitchTextView.setText("Pitch: " + valuePitch);
            rollTextView.setText("Roll: " + valueRoll);
        }
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE){
            float valuePressure = event.values[0];
            pressureTextView.setText("Pressure: "+valuePressure);
        }
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            float valueTemperature = event.values[0];
            temperatureTextView.setText("Temperature: "+ valueTemperature);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}