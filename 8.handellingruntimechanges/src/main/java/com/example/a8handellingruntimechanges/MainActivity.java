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

/* For rotate screen   */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtVw = (TextView) findViewById(R.id.TxtTime);
                txtVw.setText("" + new Date());

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        final TextView textView = (TextView) findViewById(R.id.TxtTime);
        outState.putString("key_my_data", textView.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            final TextView textView = (TextView) findViewById(R.id.TxtTime);
            String myData = savedInstanceState.getString("key_my_data");
            textView.setText(myData);
        }
    }

    public void showToast(String Msg) {

        Toast.makeText(this, Msg, Toast.LENGTH_SHORT).show();
    }
}

