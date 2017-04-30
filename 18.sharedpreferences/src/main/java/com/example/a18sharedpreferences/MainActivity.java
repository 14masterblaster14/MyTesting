package com.example.a18sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INT = "int";
    private static final String KEY_FLOAT = "float";
    private static final String KEY_LONG = "long";
    private static final String KEY_BOOLEAN = "boolean";
    private static final String KEY_STRING = "string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToShrdPrefFile();
            }
        });

        findViewById(R.id.Show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFrmShrdPrefFile();
            }
        });

    }

    private void saveToShrdPrefFile() {

        //SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_INT, 14);
        editor.putFloat(KEY_FLOAT, 7.7f);
        editor.putLong(KEY_LONG, System.currentTimeMillis());
        editor.putBoolean(KEY_BOOLEAN, true);
        editor.putString(KEY_STRING, "MasterBlaster");

        editor.commit();

    }

    private void readFrmShrdPrefFile() {

        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE);
        StringBuilder stringBuilder = new StringBuilder();

        Integer sample_int = sharedPreferences.getInt(KEY_INT, -14);
        stringBuilder.append(sample_int).append(", ");
        Float sample_float = sharedPreferences.getFloat(KEY_FLOAT, 7f);
        stringBuilder.append(sample_float).append(", ");
        Long sample_long = sharedPreferences.getLong(KEY_LONG, -1l);
        stringBuilder.append(sample_long).append(", ");
        Boolean sample_boolean = sharedPreferences.getBoolean(KEY_BOOLEAN, false);
        stringBuilder.append(sample_boolean).append(", ");
        String sample_string = sharedPreferences.getString(KEY_STRING, "Default");
        stringBuilder.append(sample_string).append(", ");

        ((TextView) findViewById(R.id.TxtView)).setText(stringBuilder.toString());

    }
}
