package com.example.a9handellingruntimechangesbyown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/* INCLUDE Configuration tag in manifest file */
public class MainActivity extends AppCompatActivity {

    String showTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = (TextView) findViewById(R.id.TxtTime);
                textView.setText(" " + new Date());
                showTime = (String) textView.getText();
            }
        });
        showToast("onCreate");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        Log.v("@Sachin", " I m here");
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            changeImage(R.drawable.teaser);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            changeImage(R.drawable.image);
        } else {
            changeImage(R.drawable.fight);
        }

        showToast("onConfigurationChanged");

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        final TextView textView = (TextView) findViewById(R.id.TxtTime);
        outState.putString("Key_My_Data", textView.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            final TextView textView = (TextView) findViewById(R.id.TxtTime);
            String myData = savedInstanceState.getString("Key_My_Data");
            textView.setText(myData);

        }
    }

    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
    }

    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
    }

    private void changeImage(int id) {

        final ImageView image = (ImageView) findViewById(R.id.ImgView);
        image.setImageResource(id);
    }

    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
