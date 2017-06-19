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


    static final CameraPosition delhi=CameraPosition.builder()
            .target(new LatLng(28.7041,77.1025))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition boston=CameraPosition.builder()
            .target(new LatLng(42.3601,71.0589))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition paris=CameraPosition.builder()
            .target(new LatLng(48.8566,2.3522))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button) findViewById(R.id.standard_map);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(delhi),1000,null);

                }
            }
        });

        Button button2=(Button) findViewById(R.id.satellite);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(boston),1000,null);
                }
            }
        });

        Button button3=(Button) findViewById(R.id.hybrid);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(paris),1000,null);
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
        CameraPosition target=CameraPosition.builder().target(chennai).zoom(15).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }
}
