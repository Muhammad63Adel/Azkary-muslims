package com.example.muhammad.azkary;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.example.muhammad.azkary.R.id.current_time;

public class four_three extends AppCompatActivity {

    Button button_play;
    TextView text_type;
    ImageView image_type;

    SeekBar seek1;
    Handler seekHandler = new Handler();
    TextView current_time;
    TextView final_time;
    String min="";
    String sec="";
    String current_min="";
    String current_sec="";

    MediaPlayer mp1;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    MediaPlayer mp5;
    MediaPlayer mp6;
    MediaPlayer mp7;
    MediaPlayer []mp;

    Button read;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_three);

        mp1 = MediaPlayer.create(four_three.this,R.raw.mishary1);
        mp2 = MediaPlayer.create(four_three.this,R.raw.mishary2);
        mp3 = MediaPlayer.create(four_three.this,R.raw.mishary3);
        mp4 = MediaPlayer.create(four_three.this,R.raw.mishary4);
        mp5 = MediaPlayer.create(four_three.this,R.raw.mishary5);
        mp6 = MediaPlayer.create(four_three.this,R.raw.mishary6);
        mp7 = MediaPlayer.create(four_three.this,R.raw.mishary7);
        mp = new MediaPlayer[]{mp1,mp2,mp3,mp4,mp5,mp6,mp7};

        i = getIntent().getIntExtra("position",-1);



        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/font12.ttf");

        image_type = (ImageView)findViewById((R.id.image_one));
        text_type = (TextView)findViewById(R.id.type);
        read = (Button)findViewById(R.id.read_button);
        read.setTypeface(tf);
        text_type.setTypeface(tf);

        switch (i) {
            case 0:
                text_type.setText("اذكار الصباح");
                image_type.setImageResource(R.drawable.morning2);
                break;
            case 1:
                text_type.setText("اذكار المساء");
                image_type.setImageResource(R.drawable.night2);
                break;
            case 2:
                text_type.setText("دعاء السفر ");
                image_type.setImageResource(R.drawable.travelling);
                break;
            case 3:
                text_type.setText("ركوب الدابه");
                image_type.setImageResource(R.drawable.car2);
                break;
            case 4:
                text_type.setText("دعاء دخول السوق");
                image_type.setImageResource(R.drawable.market2);
                break;
            case 5:
                text_type.setText("دخول المسجد ");
                image_type.setImageResource(R.drawable.mosque2);
                break;

            case 6:
                text_type.setText("الاستيقاظ من النوم ");
                image_type.setImageResource(R.drawable.home4);
                break;
        }

        read.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(four_three.this,read.class );
                intent.putExtra("id",i);
                startActivity(intent);

            }

        });





        current_time = (TextView)findViewById(R.id.current_time);
        final_time = (TextView)findViewById(R.id.duration);

        min += (mp[i].getDuration()/1000)/60;
        sec += (mp[i].getDuration()/1000)%60;
        final_time.setText(min+ ":" +sec);



        seek1 = (SeekBar) findViewById(R.id.seekbar);
        seek1.setMax(mp[i].getDuration());
        seekUpdation();


        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mp[i].seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        mp[i].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                button_play.setBackgroundResource(R.drawable.play0);


            }
        });

        button_play = (Button)findViewById(R.id.button_play_intent);
        button_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(mp[i].isPlaying()) {
                    mp[i].pause();
                    button_play.setBackgroundResource(R.drawable.play0);
                }
                else {
                    mp[i].start();
                    button_play.setBackgroundResource(R.drawable.pause_button);
                }


            }
        });

        final Button forward = (Button)findViewById(R.id.speed_forward);
        forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current_position = mp[i].getCurrentPosition();
                int forward = 5000;
                mp[i].seekTo(current_position+forward + forward);

            }
        });

        final Button reverse = (Button)findViewById(R.id.speed_reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current_position = mp[i].getCurrentPosition();
                int forward = 10000;
                mp[i].seekTo(current_position - forward);

            }
        });


    }


    Runnable run = new Runnable() {
        @Override public void run() {
            seekUpdation();} };


    public void seekUpdation() {

        seek1.setProgress(mp[i].getCurrentPosition());
        current_min += (mp[i].getCurrentPosition()/1000)/60;
        current_sec += (mp[i].getCurrentPosition()/1000)%60;
        current_time.setText(current_min+ ":" +current_sec);
        current_min ="";
        current_sec ="";
        seekHandler.postDelayed(run, 100);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }




}
