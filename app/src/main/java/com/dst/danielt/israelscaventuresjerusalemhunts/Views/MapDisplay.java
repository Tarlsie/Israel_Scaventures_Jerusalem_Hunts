package com.dst.danielt.israelscaventuresjerusalemhunts.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapDisplay extends Fragment {


    public MapDisplay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_display, container, false);
    }

}
