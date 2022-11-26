package com.example.generadordeubicaciongps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
EditText latitud, longitud;
GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitud = findViewById(R.id.latitud);
        longitud = findViewById(R.id.longitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap =googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng tigergym = new LatLng(20.3884077,-99.9525588);
        mMap.addMarker(new MarkerOptions().position(tigergym).title("TIGER GYM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tigergym));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        latitud.setText(""+latLng.latitude);
        longitud.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        latitud.setText(""+latLng.latitude);
        longitud.setText(""+latLng.longitude);
    }
}