package com.dst.danielt.israelscaventuresjerusalemhunts.Classes;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielT on 28/02/2016.
 */
 public class PicPackDetails {

    public String picName;
    public int picNum;
    public int picID;
    public PicPackDetails(){}
    public PicPackDetails(String picName, int picNum, int picID){
        this.picName = picName;
        this.picNum = picNum;
        this.picID = picID;
    }

    private List<PicPackDetails> pics;

    public List<PicPackDetails> initializePicPack(){

        pics = new ArrayList<>();

        pics.add(new PicPackDetails("Picture 1", 1,R.drawable.cardo ));
        pics.add(new PicPackDetails("Picture 2", 2,R.drawable.istanbuli ));
        pics.add(new PicPackDetails("Picture 3", 3,R.drawable.madeba ));
        pics.add(new PicPackDetails("Picture 4", 4,R.drawable.tree ));
        pics.add(new PicPackDetails("Picture 5", 5,R.drawable.wallshapes ));
        pics.add(new PicPackDetails("Picture 6", 6,R.drawable.ramban ));
        pics.add(new PicPackDetails("Picture 7", 7,R.drawable.menachemzion ));

        return pics;
    }
}
