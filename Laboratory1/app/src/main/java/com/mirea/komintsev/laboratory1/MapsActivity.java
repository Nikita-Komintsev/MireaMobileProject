package com.mirea.komintsev.laboratory1;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.mirea.komintsev.laboratory1.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnMapClickListener{
    private static final int REQUEST_LOCATION = 1;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    ArrayList<LatLng> pointList = new ArrayList<LatLng>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        MarkersViewModel markersViewModel = new ViewModelProvider(this).get(MarkersViewModel.class);
        markersViewModel.getProgressState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isVisibleProgressBar) {
                //TO DO
            }
        });
        markersViewModel.showProgress();

//        if(savedInstanceState!=null ){
//            Log.d("Tag", "savedInstanceState!=null");
//            if(savedInstanceState.containsKey("points")){
//                pointList = savedInstanceState.getParcelableArrayList("points");
//                if(pointList!=null){
//                    for(int i=0;i<pointList.size();i++){
//                        Log.d("Tag", "drawMarker");
//                        drawMarker(pointList.get(i));
//                    }
//                }
//            }
//        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.d("Tag", "onMapReady");
        for(int i=0;i<pointList.size();i++){
            Log.d("Tag", "drawMarker");
            drawMarker(pointList.get(i));
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            // permission has been granted, continue as usual
            Task<Location> locationResult = LocationServices
                    .getFusedLocationProviderClient(this)
                    .getLastLocation();
        }
        // добавление кнопки определения местоположения
        mMap.setMyLocationEnabled(true);
        // добавление кнопок изменнеия масштаба
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // отображение слоя загруженности дорог
        mMap.setTrafficEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        setUpMap();

        mMap.setOnMapClickListener(this);

        Log.d("Tag", "drawMarker");
        if(pointList!=null){
            for(int i=0;i<pointList.size();i++){
                Log.d("Tag", "drawMarker");
                drawMarker(pointList.get(i));
            }
        }
    }




    private void setUpMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng mirea = new LatLng(55.670005, 37.479894);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                mirea).zoom(12).build();
        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        mMap.addMarker(new MarkerOptions().title("МИРЭА")
                .snippet("Крупнейший политехнический ВУЗ").position(mirea));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Log.d("Tag", "onMapClick");
        drawMarker(latLng);
        pointList.add(latLng);

    }

    private void drawMarker(LatLng latLng) {
        Log.d("Tag", "drawMarker");
        mMap.addMarker(new MarkerOptions().title("Где я?")
                .snippet("Новое место").position(latLng));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Adding the pointList arraylist to Bundle
        outState.putParcelableArrayList("points", pointList);

        // Saving the bundle
        super.onSaveInstanceState(outState);
    }


}