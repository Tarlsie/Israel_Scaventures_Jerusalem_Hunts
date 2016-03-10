package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.GameData;
import com.dst.danielt.israelscaventuresjerusalemhunts.Presenters.PresenterSourceSheets;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;

public class SourceSheet extends Activity {
    TextView txtVSrcPg1, txtVSrcPg2, txtVSrcPg3, txtVSrcPg4, txtVSrcPg5, txtVSrcPg6, txtVSrcPg7, txtVSrcPgTtl;
   // ImageView imgVSource;
   String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_sheet);

        txtVSrcPgTtl = (TextView)findViewById(R.id.txtVSrcPgTtl);
        txtVSrcPg1 = (TextView)findViewById(R.id.TxtVSrcPage1);
        txtVSrcPg2 = (TextView)findViewById(R.id.TxtVSrcPage2);
        txtVSrcPg3 = (TextView)findViewById(R.id.TxtVSrcPage3);
        txtVSrcPg4 = (TextView)findViewById(R.id.TxtVSrcPage4);
        txtVSrcPg5 = (TextView)findViewById(R.id.TxtVSrcPage5);
        txtVSrcPg6 = (TextView)findViewById(R.id.TxtVSrcPage6);
        txtVSrcPg7 = (TextView)findViewById(R.id.TxtVSrcPage7);
      //  imgVSource = (ImageView) findViewById(R.id.ImgVSourceSheet);
        /////////////////////////////////////////////////////
        //Add code to find out which station has been reached
        ////////////////////////////////////////////////////


        PresenterSourceSheets pSS = new PresenterSourceSheets(getApplicationContext());
        int station = GameData.getStation();
        Log.i("station is 0", "At the begining of game");
     /*   if (station ==0){

        }
        else {*/
            data = pSS.getSheetData(station);

            int size = data.length;
            for (int i = 0; i < size; i++) {
                String text = data[i];
                switch (i) {
                    case 0:
                        txtVSrcPgTtl.setText(text);
                        break;
                    case 1:
                        txtVSrcPg1.setText(text);
                        break;
                    case 2:
                        txtVSrcPg2.setText(text);
                        break;
                    case 3:
                        txtVSrcPg3.setText(text);
                        break;
                    case 4:
                        txtVSrcPg4.setText(text);
                        break;
                    case 5:
                        txtVSrcPg5.setText(text);
                        break;
                    case 6:
                        txtVSrcPg6.setText(text);
                        break;
                    case 7:
                        txtVSrcPg7.setText(text);
                        break;
                }


            }
       // }


    }
}
