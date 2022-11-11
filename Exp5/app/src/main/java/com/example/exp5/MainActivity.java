package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    public ImageButton pausebtn, playbtn, stopbtn;
    public MediaPlayer mplayer;
    public TextView songName;

    public static int oTime = 0, sTime = 0, eTime = 0, fTime = 5000, bTime = 5000;
    public Handler hdlr = new Handler();

    void astop(){ mplayer = MediaPlayer.create(this, R.raw.audio1);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pausebtn = findViewById(R.id.btnpause);
        playbtn = findViewById(R.id.btnplay);
        stopbtn = findViewById(R.id.btnstop);
        songName = findViewById(R.id.txtSname);

        songName.setText("audio1.mp3");
        mplayer = MediaPlayer.create(this, R.raw.audio1);



        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Playing Audio", Toast.LENGTH_SHORT).show();
                mplayer.start();


            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pausing Audio", Toast.LENGTH_SHORT).show();
                mplayer.pause();

            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Stopping Audio", Toast.LENGTH_SHORT).show();
                mplayer.stop();
                astop();

            }
        });
    }}
