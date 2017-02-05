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

/* For rotate screen date should retain and image changes according to orientation */

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

