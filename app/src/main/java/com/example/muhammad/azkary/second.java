package com.example.muhammad.azkary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class second extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ArrayList<sheikh> sheikhs = new ArrayList<sheikh>();

        sheikhs.add(new sheikh("مشاري العفاسي", "كويتي", R.drawable.pic10));
        sheikhs.add(new sheikh("فهد الكندري", "كويتي", R.drawable.pic11));
        sheikhs.add(new sheikh("سعد الغامدي", "سعودي", R.drawable.pic12));



        cutom_adapter sheikh_adapters = new cutom_adapter(this, sheikhs);
        ListView listView = (ListView) findViewById(R.id.second_list_view);
        listView.setAdapter(sheikh_adapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), third_one.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), third_two.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), third_three.class);
                    startActivity(intent);
                }
            }
        });
    }
}

