package com.example.a41adapterviews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by comp on 11/30/2016.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    // private Integer[] dataset;
    private ArrayList<MyItems> dataset;

    public MyAdapter(Context context, ArrayList<MyItems> dataset) {
        this.context = context;
        this.dataset = dataset;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {

        //  return null;
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        //   return 0;
        return dataset.get(position).getItemID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*    return null; */

        final View view = inflater.inflate(R.layout.custom_items,
                null,
                false);
    /* null -->
    *   false -->        */
        ImageView image =
                (ImageView) view.findViewById(R.id.ImgViewItem);
        image.setImageResource((int) dataset.get(position).getItemID());
        //  image.setImageResource(dataset.);

        return view;

    }
}
