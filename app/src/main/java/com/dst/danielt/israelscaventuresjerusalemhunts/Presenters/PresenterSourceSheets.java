package com.dst.danielt.israelscaventuresjerusalemhunts.Presenters;

import android.content.Context;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;

/**
 * Created by danielT on 06/03/2016.
 */
public class PresenterSourceSheets {

    int station;
    Context context;
    public PresenterSourceSheets( Context context) {

        this.context = context;

    }

    public String[] getSheetData(int stat) {
        station = stat;
        String[] sourceData=null;
        switch (station) {
            case 1:
                sourceData = context.getResources().getStringArray(R.array.InformationTheCardo);
                break;
            case 2:
                sourceData = context.getResources().getStringArray(R.array.InformationMadebaMap);
                break;
            case 3:
                sourceData = context.getResources().getStringArray(R.array.InformationChurva);
                break;
            case 4:
                sourceData = context.getResources().getStringArray(R.array.InformationRambanSynagogue);
                break;
            case 5:
                sourceData = context.getResources().getStringArray(R.array.InformationIgeretHaRamban_LetteroftheAges);
                break;
            case 6:
                sourceData = context.getResources().getStringArray(R.array.InformationBroadWall);
                break;
            case 7:
                sourceData = context.getResources().getStringArray(R.array.InformationEstherCalingold);
                break;
            case 8:
                sourceData = context.getResources().getStringArray(R.array.InformationYeshivaBeitEl);
                break;
            case 9:
                sourceData = context.getResources().getStringArray(R.array.InformationTiferetYisrael);
                break;
            case 10:
                sourceData = context.getResources().getStringArray(R.array.InformationIstambuli);
                break;
            case 11:
                sourceData = context.getResources().getStringArray(R.array.InformationGalEd);
                break;
            case 12:
                sourceData = context.getResources().getStringArray(R.array.InformationBateiMachseh);
                break;

        }
        return sourceData;
    }

}
