package com.example.a61animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFadeIn, btnFadeOut, btnCrossFade, btnBlink, btnZoomIn,
            btnZoomOut, btnRotate, btnMove, btnSlideUp, btnSlideDown,
            btnBounce, btnSequential, btnTogether;

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

        // My Code starts here ...

        btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
        btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
        btnCrossFade = (Button) findViewById(R.id.btnCrossFade);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnSlideUp = (Button) findViewById(R.id.btnSlideUp);
        btnSlideDown = (Button) findViewById(R.id.btnSlideDown);
        btnBounce = (Button) findViewById(R.id.btnBounce);
        btnSequential = (Button) findViewById(R.id.btnSequential);
        btnTogether = (Button) findViewById(R.id.btnTogether);

		/*
         * Buttons click events
		 */

        // fade in
        btnFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FadeInActivity.class);
                startActivity(i);
            }
        });

        // fade out
        btnFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FadeOutActivity.class);
                startActivity(i);
            }
        });

        // cross fade
        btnCrossFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        CrossfadeActivity.class);
                startActivity(i);
            }
        });

        // blink
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BlinkActivity.class);
                startActivity(i);
            }
        });

        // Zoom In
        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ZoomInActivity.class);
                startActivity(i);
            }
        });

        // Zoom Out
        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ZoomOutActivity.class);
                startActivity(i);
            }
        });

        // Rotate
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RotateActivity.class);
                startActivity(i);
            }
        });

        // Move
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(i);
            }
        });

        // Slide Up
        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SlideUpActivity.class);
                startActivity(i);
            }
        });

        // Slide Down
        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        SlideDownActivity.class);
                startActivity(i);
            }
        });

        // Slide Down
        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BounceActivity.class);
                startActivity(i);
            }
        });

        // Sequential
        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        SequentialActivity.class);
                startActivity(i);
            }
        });


        // Together
        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        TogetherActivity.class);
                startActivity(i);
            }
        });


        // My Code ends here ....
    }

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
