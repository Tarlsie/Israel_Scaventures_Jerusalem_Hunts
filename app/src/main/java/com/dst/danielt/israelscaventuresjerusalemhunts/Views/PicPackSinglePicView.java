package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.GPSLocation;
import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.PicPackDetails;
import com.dst.danielt.israelscaventuresjerusalemhunts.Presenters.PresenterPicPackSinglePic;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;

import java.util.List;

public class PicPackSinglePicView extends Activity {
    ImageView img;
    FloatingActionButton fab;
    PresenterPicPackSinglePic picPres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_pack_single_pic_view);

        Intent pic = getIntent();
        int picNum = pic.getIntExtra("pic", -1);
        img = (ImageView)findViewById(R.id.imgVSinglePic);
        fab = (FloatingActionButton)findViewById(R.id.fabSinglePic);
        picPres = new PresenterPicPackSinglePic();
        List<PicPackDetails> pics = picPres.getPicPackData();

        if(picNum>=0) {

            img.setImageResource(pics.get(picNum).picID);

        }
        else{
            img.setImageResource(R.drawable.ic_play_dark);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("fab pressed", "message");
                //get current location
                GPSLocation loc = new GPSLocation();
                loc.getCurrentLocation();
                //check current location against location of picture
                picPres.checkPicInRange();
                //is within range
                loc.checkDistanceBetweenTwoLocations(1,2);
                //if out of range but within larger range instruct to move closer


            }
        });

    }

}
