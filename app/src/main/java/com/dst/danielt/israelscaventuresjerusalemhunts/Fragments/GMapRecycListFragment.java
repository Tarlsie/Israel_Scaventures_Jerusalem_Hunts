package com.dst.danielt.israelscaventuresjerusalemhunts.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;


public class GMapRecycListFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GMapRecycListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static GMapRecycListFragment newInstance(int columnCount) {
        GMapRecycListFragment fragment = new GMapRecycListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gmaprecyclist, container, false); //still have to confirm this is the correct xml file to inflate.
        GMapRecycListFragment.newInstance(1);
        // Set the adapter
    /*    MyGMapRecycListRecyclerViewAdapter adapter = new MyGMapRecycListRecyclerViewAdapter(MapsActivity.getDirections1());
        RecyclerView recyc =(RecyclerView)view.findViewById(R.id.ReCycVList);
        recyc.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyc.setLayoutManager(llm);
        recyc.setAdapter(adapter);
*/

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
