package com.example.muhammad.azkary;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;



import static android.R.id.text1;

public class read extends AppCompatActivity {

    TextView read_page;

    int read_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/font12.ttf");
        read_page = (TextView) findViewById(R.id.read_text);
        read_page.setTypeface(tf);


        read_position = getIntent().getIntExtra("id", -1);

        switch (read_position) {
            case 0:
                read_file("صباح.txt");
                break;
            case 1:
                read_file("مساء.txt");
                break;
            case 2:
                read_file("سفر.txt");
                break;
            case 3:
                read_file("الركوب.txt");
                break;
            case 4:
                read_file("سوق.txt");
                break;
            case 5:
                read_file("المسجد.txt");
                break;
            case 6:
                read_file("بعد النوم.txt");
                break;
        }

    }

    public void read_file(String file_name) {

        String text = "";
        try {
            InputStream inputStream = getAssets().open(file_name);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        read_page.setText(text);
    }





}