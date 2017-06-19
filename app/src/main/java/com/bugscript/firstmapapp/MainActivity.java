package com.bugscript.firstmapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button) findViewById(R.id.standard_map);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        Button button2=(Button) findViewById(R.id.satellite);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });

        Button button3=(Button) findViewById(R.id.hybrid);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });

        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady=true;
        m_map=map;
        LatLng chennai=new LatLng(13.0827,80.2707);
        CameraPosition target=CameraPosition.builder().target(chennai).zoom(20).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }
}
