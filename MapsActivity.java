package com.parkingtracer.simon.parkingtracer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    Context contex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    LatLng latlng1,latlng2,latlng3,latlng4,latlng5,latlng7;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        //1st marker
        latlng1 = new LatLng(23.7929359, 90.4063594);
        latlng2 = new LatLng(23.7931589,90.4065296);
        latlng3 = new LatLng(23.7933958,90.4076239);
        latlng4 = new LatLng(23.7952885,90.4079991);
        latlng5 = new LatLng(23.7930291,90.4055878);
        latlng7 = new LatLng(23.7931588,90.4045854);


        final Marker myMarker= mMap.addMarker(new MarkerOptions().position(latlng1).title("Banani Super Market Parking(backside)").snippet("Fare 0 BDT"));
        final Marker myMarker2= mMap.addMarker(new MarkerOptions().position(latlng2).title("Banani Super Market Parking(Enamul haque road))").snippet("Fare 0 BDT"));
        final Marker myMarker3= mMap.addMarker(new MarkerOptions().position(latlng3).title("Banani Kacha bazar").snippet("Fare 0 BDT"));
        final Marker myMarker4= mMap.addMarker(new MarkerOptions().position(latlng4).title("Road 24, Block K").snippet("Fare 0 BDT"));
        final Marker myMarker5= mMap.addMarker(new MarkerOptions().position(latlng5).title("Road 17, Swapno").snippet("Fare 0 BDT"));
        final Marker myMarker6= mMap.addMarker(new MarkerOptions().position(latlng7).title("Road 17, Hotel Sarina").snippet("Fare 0 BDT"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng1));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
        mMap.animateCamera(zoom);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.equals(myMarker)) {
                    String val1 = getAddressFromLatLng(latlng1);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark1", val1);
                    startActivity(intent);
                } else if (marker.equals(myMarker2)) {
                    String val2 = getAddressFromLatLng(latlng2);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark2", val2);
                    startActivity(intent);
                } else if (marker.equals(myMarker3)) {
                    String val3 = getAddressFromLatLng(latlng3);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark3", val3);
                    startActivity(intent);
                } else if (marker.equals(myMarker4)) {
                    String val4 = getAddressFromLatLng(latlng4);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark4", val4);
                    startActivity(intent);
                } else if (marker.equals(myMarker5)) {
                    String val5 = getAddressFromLatLng(latlng5);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark5", val5);
                    startActivity(intent);
                } else if (marker.equals(myMarker6)) {
                    String val6 = getAddressFromLatLng(latlng7);
                    Intent intent = new Intent(MapsActivity.this, ShowActivity.class);
                    intent.putExtra("mark6", val6);
                    startActivity(intent);
                }


            }
        });



       

    }



    //adress get method using latlong
    private String getAddressFromLatLng( LatLng latLng ) {
        Geocoder geocoder = new Geocoder( this );

        String address = "";
        try {
            address = geocoder
                    .getFromLocation( latLng.latitude, latLng.longitude, 1 )
                    .get(0 ).getAddressLine( 0 );
        } catch (IOException e ) {
        }

        return address;
    }


    //----------------------------- testing method

    // testikng method ----------------------------
}
