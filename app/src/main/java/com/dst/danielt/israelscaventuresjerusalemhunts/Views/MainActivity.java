package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.GameData;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameData.getInstance();



    }

    @Override
    protected void onResume() {
        super.onResume();

        Random random = new Random();
        int num = random.nextInt(12)+1;
        Log.i("random number ", Integer.toString(num));
        GameData.setStation(num);

        Button start = (Button)findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Game.class);
                startActivity(i);
            }
        });


    }
}
