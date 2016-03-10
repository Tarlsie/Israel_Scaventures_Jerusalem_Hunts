package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        RecyclerView recyc =(RecyclerView)findViewById(R.id.ReCycVList);
        recyc.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyc.setLayoutManager(llm);

        DirectionsRecyclerViewAdapter adapter = new DirectionsRecyclerViewAdapter(getDirections1());
        recyc.setAdapter(adapter);



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

        // Add a marker in Sydney and move the camera
        LatLng startPoint = new LatLng(31.774284, 35.231524);
        mMap.addMarker(new MarkerOptions().position(startPoint).title("Scav Hunt Start Point"));
        //CameraPosition.builder().zoom(18).build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 20));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(startPoint));
     //   mMap.animateCamera(CameraUpdateFactory.zoomTo(19));
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
