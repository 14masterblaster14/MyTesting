package com.example.a4adapterviews;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by comp on 9/7/2016.
 */
public class GridViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState /*, PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState   /*, persistentState*/);

        setContentView(R.layout.grid_view);

        final GridView gridButtons = (GridView) findViewById(R.id.GridView);
    }
}
