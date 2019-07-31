package com.example.muhammad.azkary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class third_two extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_two);
        name = (TextView)findViewById(R.id.name);


        final ArrayList<sheikh> sheikhs = new ArrayList<sheikh>();

        sheikhs.add(new sheikh("اذكار الصباح", "من بعد صلاة الفجر وحتى شروق الشمس", R.drawable.sun));
        sheikhs.add(new sheikh("اذكار المساء", "من بعد صلاة العصر وحتى غروب الشمس", R.drawable.moon2));
        sheikhs.add(new sheikh("دعاء السفر", "يقال عند السفر", R.drawable.travelling));
        sheikhs.add(new sheikh("ركوب الدابه", "عند ركوب السياره او اي شئ ينقلك", R.drawable.car2));
        sheikhs.add(new sheikh("دخول السوق", "عند دخول الاسواق او شراء اي شئ", R.drawable.market2));
        sheikhs.add(new sheikh("دخول المسجد", "يقال عند دخول المسجد بالقدم اليمنى", R.drawable.mosque2));
        sheikhs.add(new sheikh("الاستيقاظ من النوم ", "يقال مباشرة عن الاستيقاظ من النوم", R.drawable.home4));



        cutom_adapter sheikh_adapters = new cutom_adapter(this, sheikhs);
        final ListView listView = (ListView) findViewById(R.id.List1_azkary);
        listView.setAdapter(sheikh_adapters);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(third_two.this, four_two.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }


        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }
}
