package com.example.a9handellingruntimechangesbyown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            changeImage(R.drawable.teaser);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            changeImage(R.drawable.fight);
        } else {
            changeImage(R.drawable.image);
        }

        showToast("onConfigurationChanged");
        TextView txtvw = (TextView) findViewById(R.id.TxtTime);
        txtvw.setText("" + showTime);
    }


    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
    }

    protected void onStart() {
        super.onStart();
        showToast("onStart");
    }

    protected void onResume() {
        super.onResume();
        showToast("onResume");
    }

    protected void onPause() {
        super.onPause();
        showToast("onPause");
    }

    protected void onStop() {
        super.onStop();
        showToast("onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
    }

    private void changeImage(int id) {

        final ImageView image = (ImageView) findViewById(R.id.ImgView);
        image.setImageResource(id);
    }

    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
