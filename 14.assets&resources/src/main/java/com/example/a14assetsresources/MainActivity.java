package com.example.a14assetsresources;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readAssets();

        String[] cities = getResources().getStringArray(R.array.Cities);
    }

    private void readAssets() {

        AssetManager manager = getAssets();

        try {
            InputStream is = manager.open("assets.txt");
            StringBuilder builder = new StringBuilder();

            while (true) {

                int ch = is.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }

            Log.i("@Assets&Resources", builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
