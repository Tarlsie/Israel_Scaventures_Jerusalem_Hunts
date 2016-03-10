package com.dst.danielt.israelscaventuresjerusalemhunts.Fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;

import java.util.List;


public class MyGMapRecycListRecyclerViewAdapter extends RecyclerView.Adapter<MyGMapRecycListRecyclerViewAdapter.ViewHolder>  {

    private final List<String> mValues;


    public MyGMapRecycListRecyclerViewAdapter(List<String> items) {
        mValues = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gmaprecyclist_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
     //   holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position));
        holder.mContentView.setText(mValues.get(1));
        holder.imgV.setImageResource(R.drawable.ic_play_dark);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public  View mView;
       // public final TextView mIdView;
        public  TextView mContentView;

        public  ImageView imgV;

        public ViewHolder(View view) {
            super(view);
            mView = view;
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
