package com.example.a102fragments2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    int fragID = 0;

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

        /* My code starts here ----> */

        findViewById(R.id.Btn_Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runLoginFragTxn();
            }
        });

        findViewById(R.id.Btn_Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runRegFragTxn();

            }
        });


    /*
        findViewById(R.id.Btn_Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragID = 1;
            }
        });

        findViewById(R.id.Btn_Register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        /*        fragID = 2;

            }
        });
        runFragTxn(fragID);
    */
        /* My code Ends here ----> */
    }

    /* My code starts here ----> */

    private void runLoginFragTxn() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.Frame_Container, new LoginFragment());
        transaction.commit();
    }

    private void runRegFragTxn() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.Frame_Container, new RegisterFragment());
        transaction.commit();
    }
     /*
    private void runFragTxn (int fragID1){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
     if (fragID1 == 1)
        {
            transaction.replace(R.id.Frame_Container, new LoginFragment());
        }
        else if ( fragID1 == 2)
        {
            transaction.replace(R.id.Frame_Container, new RegisterFragment());
        }

        transaction.commit();
    }
    */

    /* My code Ends here ----> */

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
