package com.dst.danielt.israelscaventuresjerusalemhunts.Presenters;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.PicPackDetails;

import java.util.List;

/**
 * Created by danielT on 09/03/2016.
 */
public class PresenterPicPackFrag {

    public List<PicPackDetails> getPicPackData(){
        PicPackDetails picDet = new PicPackDetails();
        List<PicPackDetails> pics1 = picDet.initializePicPack();
        return pics1;

    }
}
