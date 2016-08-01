package com.example.a9handellingruntimechangesbyown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = (TextView) findViewById(R.id.TxtTime);
                textView.setText(" " + new Date());
            }
        });
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

    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
