package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.dst.danielt.israelscaventuresjerusalemhunts.Manifest;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationListener;
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

import java.security.Permission;
import java.security.Permissions;

public class MapToNextLoc extends FragmentActivity implements LocationListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    GoogleApiClient client;
    String mapsDirectApi;
    LocationRequest getLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_to_next_loc);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(AppIndex.API).build();

        getLoc = new LocationRequest();
        getLoc.setInterval(15000);
        getLoc.setFastestInterval(10000);
        getLoc.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

    }


    @Override
    protected void onStart() {

        client.connect();
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapToNextLoc Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dst.danielt.israelscaventuresjerusalemhunts.Views/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }


    @Override
    protected void onStop() {
        client.disconnect();
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapToNextLoc Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.dst.danielt.israelscaventuresjerusalemhunts.Views/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //get lat and long from shared preferences
        double lat = 10.2111;
        double longitude = 20.32222;
        // Add a marker in Sydney and move the camera
        mapsDirectApi="AIzaSyAPHUip-1VFSVeLj69eX0Xaku58yVtfRP0";




        LocationSettingsRequest.Builder build = new LocationSettingsRequest.Builder().addLocationRequest(getLoc);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(client,build.build());

        Log.i("location result", result.toString());



    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i("On Connected ", "GoogleApiClient connected");

        //check for permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.MAPS_RECEIVE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.MAPS_RECEIVE},
                    1);

        }
        //Location mLastKnownlocation =
                LocationServices.FusedLocationApi.requestLocationUpdates(client, getLoc, (LocationListener) this);
         //   double latitude1 = mLastKnownlocation.getLatitude();
         //   double lng1 = mLastKnownlocation.getLongitude();
         //   Log.i("Last known location ", "lat " + latitude1 + " long " + lng1);

        }



    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
      double getLat2 = location.getLatitude();
        double getLng2 = location.getLongitude();

        Log.i("Location changed location ", "lat "+getLat2+ " long "+getLng2);
        //mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
       // updateUI();

        LatLng locA = new LatLng(getLat2, getLng2);
        mMap.addMarker(new MarkerOptions().position(locA).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locA, 18));
    }
}
