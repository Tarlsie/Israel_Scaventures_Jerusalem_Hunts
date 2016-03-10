package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dst.danielt.israelscaventuresjerusalemhunts.Fragments.GMaps;
import com.dst.danielt.israelscaventuresjerusalemhunts.Fragments.PicPackFrag;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity implements PicPackFrag.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager vp = (ViewPager)findViewById(R.id.gameViewPager);
        setupViewPager(vp);
        TabLayout tl = (TabLayout)findViewById(R.id.tabLayout1);
        tl.setupWithViewPager(vp);

    }

    public void setupViewPager(ViewPager vp ){
        ViewPagerAdapter adapter = new  ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GMaps(), "Game");
        adapter.addFragment(new PicPackFrag(), "Pic Pack");
        vp.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fmList = new ArrayList<>();
        private final List<String> fmTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fmTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fmList.get(position);
        }

        @Override
        public int getCount() {
            return fmList.size();
        }

        public void addFragment(Fragment frg, String title){
            fmList.add(frg);
            fmTitleList.add(title);
        }



    }



}
