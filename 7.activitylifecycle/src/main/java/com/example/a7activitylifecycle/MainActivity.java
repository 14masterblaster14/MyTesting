package com.example.a7activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.v("ActivityLifeCycle", msg);

    }
}
