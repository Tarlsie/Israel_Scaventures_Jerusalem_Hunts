package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.location.LocationProvider;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Route;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

public class MapsGoToLocationB extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient client;
    private GoogleMap mMap;
 //   String mapsDirectApi= "AIzaSyAPHUip-1VFSVeLj69eX0Xaku58yVtfRP0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_go_to_location_b);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    /*
        client = new  GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

    }


    @Override
    protected void onStart() {

        client.connect();
        super.onStart();
    }


    @Override
    protected void onStop() {
        client.disconnect();
        super.onStop();

    }
    */

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //get lat and long from shared preferences
        double lat = 10.2111;
        double longitude = 20.32222;
        // Add a marker in Sydney and move the camera


/*
        LocationRequest getLoc = new LocationRequest();
        getLoc.setInterval(15000);
        getLoc.setFastestInterval(10000);
        getLoc.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationSettingsRequest.Builder build = new LocationSettingsRequest.Builder().addLocationRequest(getLoc);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(client,build.build());

        Log.i("location result", result.toString());
*/
        LatLng presentLoc = new LatLng(1.2,2.3);

        LatLng locA = new LatLng(lat, longitude);
        mMap.addMarker(new MarkerOptions().position(locA).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locA, 18));

        /*GoogleDirection.withServerKey(mapsDirectApi).from(presentLoc).to(locA).transportMode(TransportMode.WALKING).execute(new DirectionCallback() {
            @Override
            public void onDirectionSuccess(Direction direction, String rawBody) {

                Route route = direction.getRouteList().get(0);
               // Polyline poly = route.getOverviewPolyline().getPointList().get(1);

            }

            @Override
            public void onDirectionFailure(Throwable t) {

            }
        });
*/
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
