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

        Button start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, Game.class);
                Intent i = new Intent(MainActivity.this, MapsActivity.class);

                startActivity(i);
            }
        });


        Button source = (Button)findViewById(R.id.buttonSource);
        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SourceSheet.class);
                startActivity(i);
            }
        });

        Button questionBtn = (Button)findViewById(R.id.buttonQuestion);
        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(i);
            }
        });
    }
}
