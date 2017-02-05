package com.example.a42adapterviewsbuttonadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by comp on 9/7/2016.
 */
public class ButtonAdapter extends BaseAdapter {

    private Context context;

    public ButtonAdapter(Context context) {
        this.context = context;
    }

    /*???^^*/

    @Override
    public int getCount() {
        return 14;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     /*   return null;  */

        Button button = new Button(context);


        button.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT));
        button.setText("" + position);

        return button;
    }
}
