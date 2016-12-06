package com.example.a41adapterviews;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // My code starts here....
        useGridView();
    }

    private void useGridView() {

      /*
       Integer[] dataset = {    R.drawable.s1,
                                R.drawable.s2,
                                R.drawable.s1,
                                R.drawable.s2,
                               R.drawable.s3,
                               R.drawable.s4,
                               R.drawable.s5,
                               R.drawable.s6,
                               R.drawable.s7,
                               R.drawable.s8,
                               R.drawable.s9,
                               R.drawable.s10
        };
        */
        ArrayList<MyItems> dataset = new ArrayList<>();

        MyItems item1 = new MyItems();
        item1.setItemID(1);
        item1.setImageID(R.drawable.s1);
        item1.setTextName("S1");
        dataset.add(item1);

        MyItems item2 = new MyItems();
        item2.setItemID(2);
        item2.setImageID(R.drawable.s2);
        item2.setTextName("S2");
        dataset.add(item2);

        MyItems item3 = new MyItems();
        item3.setItemID(3);
        item3.setImageID(R.drawable.s3);
        item3.setTextName("S3");
        dataset.add(item3);

        MyItems item4 = new MyItems();
        item4.setItemID(4);
        item4.setImageID(R.drawable.s4);
        item4.setTextName("S4");
        dataset.add(item4);


        MyAdapter adapter = new MyAdapter(this, dataset);
        GridView gridView = (GridView) findViewById(R.id.GridView);
        gridView.setAdapter(adapter);
    }
    // My code ends here....

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
