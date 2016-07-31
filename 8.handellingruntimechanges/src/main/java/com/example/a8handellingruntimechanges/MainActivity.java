package com.example.a8handellingruntimechanges;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class Click implements View.OnClickListener {

            @Override
            public void onClick(View v) {


                TextView TxtVw = (TextView) findViewById(R.id.TxtTime);
                TxtVw.setText("" + new Date());


/*
        findViewById(R.id.BtnSubmit).setOnClickListener(new
*/
            }

        }
        showToast("onCreate");
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

    public void showToast(String Msg){

        Toast.makeText(this ,Msg,Toast.LENGTH_SHORT).show();
    }
}

