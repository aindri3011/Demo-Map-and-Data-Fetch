package com.aindri.demomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
GoogleMap map;
SupportMapFragment mapFragment;
ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
LatLng abc=new LatLng(2.7311,75.8893);
LatLng abc1=new LatLng(23.7311,76.8893);
LatLng abc2=new LatLng(22.7311,75.8893);
LatLng abc3=new LatLng(20.7311,75.8893);
LatLng abc4=new LatLng(17.7311,75.0093);
LatLng abc5=new LatLng(12.7311,74.8893);
LatLng abc6=new LatLng(22.7311,65.8893);
LatLng abc7=new LatLng(16.7655,55.6543);
LatLng abc8=new LatLng(16.6754,54.5634);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(abc);
        arrayList.add(abc1);
        arrayList.add(abc2);
        arrayList.add(abc3);
        arrayList.add(abc4);
        arrayList.add(abc5);
        arrayList.add(abc6);
        arrayList.add(abc7);
        arrayList.add(abc8);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
    map=googleMap;
    int i;
    for(i=0;i<arrayList.size();i++){
        map.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
        map.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        map.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
    }

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MainActivity.this,SwitchActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}