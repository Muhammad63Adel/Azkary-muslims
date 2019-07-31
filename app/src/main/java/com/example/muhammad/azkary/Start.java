package com.example.muhammad.azkary;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.typeface;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        final Button start = (Button)findViewById(R.id.start_button);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/font12.ttf");
        start.setTypeface(tf);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Start.this,third_one.class);
                startActivity(i);
            }
        });
    }
}
