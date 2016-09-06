package com.example.a4adapterviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  useArrayAdapter();  */
        useCustomAdapter();

    }

    private void useArrayAdapter() {

        ArrayList<String> dataset = new ArrayList<>();

        dataset.add("America");
        dataset.add("Bangladesh");
        dataset.add("Canada");
        dataset.add("Denmark");
        dataset.add("England");

        ListView listview = (ListView) findViewById(R.id.ListView);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataset);

        listview.setAdapter(adapter);
    }

    private void useCustomAdapter() {

        ArrayList<MyItems> dataset = new ArrayList<>();

        MyItems item1 = new MyItems();
        item1.setItemID(1);
        item1.setImageID(R.drawable.teaser);
        item1.setTextName("America");
        dataset.add(item1);

        MyItems item2 = new MyItems();
        item1.setItemID(2);
        item1.setImageID(R.drawable.fight);
        item1.setTextName("Bangladesh");
        dataset.add(item2);

        MyItems item3 = new MyItems();
        item1.setItemID(3);
        item1.setImageID(R.mipmap.ic_launcher);
        item1.setTextName("China");
        dataset.add(item1);

        MyItems item4 = new MyItems();
        item1.setItemID(4);
        item1.setImageID(R.mipmap.image);
        item1.setTextName("Denmark");
        dataset.add(item1);

        ListView listview = (ListView) findViewById(R.id.ListView);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataset);

        listview.setAdapter(adapter);
    }

}
