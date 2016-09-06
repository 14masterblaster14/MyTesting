package com.example.a4adapterviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by comp on 8/28/2016.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MyItems> dataset;

    public MyAdapter(Context context, ArrayList<MyItems> dataset) {

        this.context = context;
        this.dataset = dataset;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /*  Alt Ent : getCount, getItem, getItemId, getView are auto generated methods
        ToDo : write bodies for this methods                        */

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataset.get(position).getItemID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    /*    return null; */

        ImageView imageView =


    }


}
