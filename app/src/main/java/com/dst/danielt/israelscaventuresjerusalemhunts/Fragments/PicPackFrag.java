package com.dst.danielt.israelscaventuresjerusalemhunts.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.PicPackDetails;
import com.dst.danielt.israelscaventuresjerusalemhunts.Presenters.PresenterPicPackFrag;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;
import com.dst.danielt.israelscaventuresjerusalemhunts.Views.PicPackSinglePicView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PicPackFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PicPackFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicPackFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PicPackFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PicPackFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static PicPackFrag newInstance(String param1, String param2) {
        PicPackFrag fragment = new PicPackFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pic_pack, container, false);

        //set recyclerview for pic cards
        RecyclerView rv = (RecyclerView)v.findViewById(R.id.recVPicsPack);
        rv.setHasFixedSize(true);

        //set gridlayoutmanager

        GridLayoutManager grdLManager = new GridLayoutManager(getContext(),2);
        rv.setLayoutManager(grdLManager);

        PicPackRecyclerAdapter adapter = new PicPackRecyclerAdapter(new PresenterPicPackFrag().getPicPackData());
        rv.setAdapter(adapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public class PicPackRecyclerAdapter extends RecyclerView.Adapter<PPViewHolder>{

       View v;
        List<PicPackDetails> pics;
        ViewGroup vg ;
        PicPackRecyclerAdapter(List<PicPackDetails> pics){
            this.pics = pics;
        }

        @Override
        public PPViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            vg = parent;
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.picpackcard,parent, false);
            PPViewHolder ppVH = new PPViewHolder(v);
            return ppVH;
        }

        @Override
        public void onBindViewHolder(PPViewHolder holder, final int position) {

            final TextView txtV1 = holder.txtV;
            Bitmap pic = BitmapFactory.decodeResource(vg.getContext().getResources(),pics.get(position).picID );
            if(pic!=null){
                Log.i("pic value is not null", pic.toString());
            }
            else {
                Log.i("pic value is NULLL booo", pic.toString());
            }


            holder.imgV.setImageResource(pics.get(position).picID);
            holder.txtV.setText(pics.get(position).picName);

            //Asyncronous generation of the palette and the colours for the textview text colour and background
            Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {

                    Palette.Swatch textLight = palette.getVibrantSwatch();
                    Palette.Swatch txtBack = palette.getLightMutedSwatch();
                    if(textLight!=null && txtBack!=null) {
                        txtV1.setTextColor(textLight.getRgb());
                        txtV1.setBackgroundColor(txtBack.getTitleTextColor());
                    }
                }
            };

            if (pic !=null && !pic.isRecycled()){
                Palette.from(pic).generate(paletteListener);
            }


/*
//if palette colours dont work with can be used to colour the text and the background of the textviews

            if(Build.VERSION.SDK_INT <=22) {
                holder.txtV.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                holder.txtV.setTextColor(getResources().getColor(R.color.orangeish));
            }
            else if(Build.VERSION.SDK_INT >=23)  {
                holder.txtV.setBackgroundColor(getResources().getColor(R.color.colorAccent, null));
                holder.txtV.setTextColor(getResources().getColor(R.color.orangeish, null));

            }
*/

            v=holder.view;
            holder.cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //open into larger screen using motion
                    Log.i("cardview on click", "Pic has been Clicked "+position);
                    Intent i= new Intent(getActivity(), PicPackSinglePicView.class);
                    String transitionName = getString(R.string.transition_string);
                   // View crdV = v.findViewById(R.id.linLayCardViewPicPack);

                    ActivityOptionsCompat aoc = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),v.findViewById(R.id.crdVPicPack),transitionName);  //v.findViewById(R.id.imgVCrd1)
                    i.putExtra("pic", position);

                    ActivityCompat.startActivity(getActivity(),i,aoc.toBundle());


                }
            });

        }

        @Override
        public int getItemCount() {
            return pics.size();
        }


    }


    public static class PPViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        View view;
        CardView cv;
        TextView txtV;
        ImageView imgV;

        public PPViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            cv = (CardView)itemView.findViewById(R.id.crdVPicPack);
            txtV = (TextView)itemView.findViewById(R.id.txtVTitleCrdV);
            imgV = (ImageView)itemView.findViewById(R.id.imgVCrd1);

        }

        @Override
        public void onClick(View v) {
            Log.i("cardview on click", "Clicked");
        }
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
