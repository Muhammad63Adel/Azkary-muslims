package com.example.muhammad.azkary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muhammad on 8/6/2018.
 */

public class cutom_adapter extends ArrayAdapter<sheikh> {

    private static final String LOG_TAG = cutom_adapter.class.getSimpleName();


    public cutom_adapter(Activity context, ArrayList< sheikh> sheikhs){

        super(context, 0, sheikhs);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        sheikh current_Sheikh = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        assert current_Sheikh != null;
        nameTextView.setText(current_Sheikh.getname());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView nationalityTextView = (TextView) listItemView.findViewById(R.id.nationality);
        nationalityTextView.setText(current_Sheikh.getnationality());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(current_Sheikh.getpic());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }
}
