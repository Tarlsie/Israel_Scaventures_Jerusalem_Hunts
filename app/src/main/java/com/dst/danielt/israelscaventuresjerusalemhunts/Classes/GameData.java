package com.dst.danielt.israelscaventuresjerusalemhunts.Classes;

import android.util.Log;

/**
 * Created by danielT on 07/03/2016.
 */
public class GameData {

    private static int station;
    String stationName;

    public static int getInstance(){

        station =0;

        return station;
    }
    public static  void setStation(int i){
        station = i;
        Log.i("GameData station settin", Integer.toString(station));
    }
    public static int getStation(){
        return station;
    }
}
