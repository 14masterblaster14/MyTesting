package com.example.layoutsviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*    setContentView(R.layout.activity_main);     */
       /*   setContentView(R.layout.relative_layout);  */
        setContentView(R.layout.table_layout);
      /*    setContentView(R.layout.absolute_layout);      ---> Not Recommanded and absolute layout */
      /*    setContentView(R.layout.frame_layout);  ---> Supposed to contain only one view, but can accomodate multiple views */

    }
}
