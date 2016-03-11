package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dst.danielt.israelscaventuresjerusalemhunts.Fragments.PicPackFrag;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        LocationListener {

    Context context;
    private GoogleMap mMap;
    ArrayList<Marker> markers;
    Location mCurrentLocation;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        context = this;
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RecyclerView recyc = (RecyclerView) findViewById(R.id.ReCycVList);
        recyc.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyc.setLayoutManager(llm);

        DirectionsRecyclerViewAdapter adapter = new DirectionsRecyclerViewAdapter(getDirections1());
        recyc.setAdapter(adapter);

        markers = new ArrayList<>();

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        mCurrentLocation = getMyLocation();
        resetMapZoom();
    }


    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        resetMapZoom();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

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
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Toast.makeText(context, "aaaaa", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        // Add a marker and move the camera
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        addMarkerToMap(31.774284, 35.231524, "cardo", convertResToBitmap(R.drawable.cardo));
        addMarkerToMap(40.774284, 35.231524, "madeba", convertResToBitmap(R.drawable.madeba));
        addMarkerToMap(31.774284, 45.231524, "ramban", convertResToBitmap(R.drawable.ramban));

        resetMapZoom();
    }

    public Bitmap convertResToBitmap(int resource) {
        return BitmapFactory.decodeResource(this.getResources(), resource);
    }

    public void addMarkerToMap(double latitude,
                               double longitude,
                               String pointName,
                               Bitmap photo) {
//        LatLng startPoint = new LatLng(31.774284, 35.231524);

        MarkerOptions markerOption = new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title(pointName);

        // Changing marker icon
//        Bitmap smallPhoto = Bitmap.createScaledBitmap(photo, 100, 100, true);
//        Bitmap roundPhoto = getCircularBitmap(smallPhoto);
//        markerOption.icon(BitmapDescriptorFactory.fromBitmap(roundPhoto));

        Marker mark = mMap.addMarker(markerOption);

        markers.add(mark);
    }

    public void resetMapZoom() {
        if(mMap == null) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        mCurrentLocation = getMyLocation();

        if (mCurrentLocation != null) {
            builder.include(new LatLng(mCurrentLocation.getLatitude(),
                    mCurrentLocation.getLongitude()));
        }
        LatLngBounds bounds = builder.build();
        int padding = 100; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        mMap.animateCamera(cu);
    }

    public Location getMyLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);

        Location location = null;
        for (int i = 0; i < providers.size(); i++) {
            location = lm.getLastKnownLocation(providers.get(i));
            if (location != null)
                break;
        }

        return location;
    }

    public Bitmap getCircularBitmap(Bitmap bitmap)
    {
        Bitmap output;

        if (bitmap.getWidth() > bitmap.getHeight()) {
            output = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } else {
            output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        float r = 0;

        if (bitmap.getWidth() > bitmap.getHeight()) {
            r = bitmap.getHeight() / 2;
        } else {
            r = bitmap.getWidth() / 2;
        }

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(r, r, r, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return addBorderToRoundBitmap(output);
    }

    public Bitmap addBorderToRoundBitmap(Bitmap bitmap) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int radius = Math.min(h / 2, w / 2);
        Bitmap output = Bitmap.createBitmap(w + 8, h + 8, Bitmap.Config.ARGB_8888);

        Paint p = new Paint();
        p.setAntiAlias(true);

        Canvas c = new Canvas(output);
        c.drawARGB(0, 0, 0, 0);
        p.setStyle(Paint.Style.FILL);

        c.drawCircle((w / 2) + 4, (h / 2) + 4, radius, p);

        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        c.drawBitmap(bitmap, 4, 4, p);
        p.setXfermode(null);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStrokeWidth(4);
        c.drawCircle((w / 2) + 4, (h / 2) + 4, radius, p);

        return output;
    }

    public List<String> getDirections1() {

        List<String> directions1 = new ArrayList<>();
        directions1.add(getResources().getString(R.string.direction1a));
        directions1.add(getResources().getString(R.string.direction1b));
        directions1.add(getResources().getString(R.string.direction1c));
        directions1.add(getResources().getString(R.string.direction1d));
        directions1.add(getResources().getString(R.string.direction1e));

        return directions1;
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


    public class DirectionsRecyclerViewAdapter extends RecyclerView.Adapter<DirectViewHolder> {

        private final List<String> mValues;


        public DirectionsRecyclerViewAdapter(List<String> items) {
            mValues = items;

        }

        @Override
        public DirectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_gmaprecyclist, parent, false);

            DirectViewHolder dirVH = new DirectViewHolder(view);
            return dirVH;
        }

        @Override
        public void onBindViewHolder(DirectViewHolder holder, final int position) {
            //   holder.mItem = mValues.get(position);
            //holder.mIdView.setText(mValues.get(position));
            holder.mContentView.setText(mValues.get(position));
            holder.imgV.setImageDrawable(getResources().getDrawable(R.drawable.common_google_signin_btn_icon_dark,null));


        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }
        public class DirectViewHolder extends RecyclerView.ViewHolder {

            // public final TextView mIdView;
            public TextView mContentView;

            public ImageView imgV;

            public DirectViewHolder(View view) {
                super(view);

                //  mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                imgV = (ImageView) view.findViewById(R.id.ImgVgMapRecycList);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }

}
