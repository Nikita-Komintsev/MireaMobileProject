package com.mirea.komintsev.mireaproject.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirea.komintsev.mireaproject.R;

import java.util.Objects;

public class MapsFragment extends Fragment {
    private static final int REQUEST_LOCATION = 1;
    private GoogleMap mMap;
    private final OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            // разрешения
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION);
            } else {
                Task<Location> locationResult = LocationServices
                        .getFusedLocationProviderClient(getActivity())
                        .getLastLocation();
            }
            ///////////
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.setTrafficEnabled(true);
            // Add a markers
            setMarkers();
        }

        private void setMarkers() {
            LatLng mirea1 = new LatLng(55.670005, 37.479894);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    mirea1).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
            mMap.addMarker(new MarkerOptions().title(" г. Москва, Проспект Вернадского, д. 78")
                    .snippet("Координаты: 55.670005, 37.479894").position(mirea1));

            LatLng mirea2 = new LatLng(55.661984, 37.476789);
            mMap.addMarker(new MarkerOptions().title("г. Москва, Проспект Вернадского, д. 86")
                    .snippet("Координаты: 55.661984, 37.476789").position(mirea2));

            LatLng mirea3 = new LatLng(55.793690, 37.701722);
            mMap.addMarker(new MarkerOptions().title("г. Москва, ул. Стромынка, д.20")
                    .snippet("Координаты: 55.793690, 37.701722").position(mirea3));

            LatLng mirea4 = new LatLng(55.731751, 37.574918);
            mMap.addMarker(new MarkerOptions().title("г. Москва, улица Малая Пироговская, д. 1, стр. 5")
                    .snippet("Координаты: 55.731751, 37.574918").position(mirea4));

            LatLng mirea5 = new LatLng(55.764957, 37.741394);
            mMap.addMarker(new MarkerOptions().title("г. Москва, 5-я улица Соколиной Горы, д. 22")
                    .snippet("Координаты: 55.764957, 37.741394").position(mirea5));

            LatLng mirea6 = new LatLng(55.728787, 37.573177);
            mMap.addMarker(new MarkerOptions().title("г. Москва, ул. Усачева, д.7/1")
                    .snippet("Координаты: 55.728787, 37.573177").position(mirea6));

            LatLng mirea7 = new LatLng(45.052115, 41.912619);
            mMap.addMarker(new MarkerOptions().title("г. Ставрополь, Проспект Кулакова, д. 8 в квартале 601")
                    .snippet("Координаты: 45.052115, 41.912619").position(mirea7));

            LatLng mirea8 = new LatLng(55.965723, 38.048648);
            mMap.addMarker(new MarkerOptions().title("г. Фрязино, ул. Вокзальная, д.2а")
                    .snippet("Координаты: 55.965723, 38.048648").position(mirea8));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
        FloatingActionButton fab = requireActivity().findViewById(R.id.fab);
        fab.hide();
    }
}