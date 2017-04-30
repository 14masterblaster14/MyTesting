package com.example.a191externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        importanatUtilityMethods();

        findViewById(R.id.Btn_Save_Public).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToPublicExternalStorage();
            }
        });

        findViewById(R.id.Btn_Display_Public).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromPublicExternalStorage();
            }
        });

        findViewById(R.id.Btn_Save_App_Private).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToAppPrivateExternalStorage();
            }
        });

        findViewById(R.id.Btn_Display_App_Private).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromAppPrivateExternalStorage();
            }
        });

    }


    private void writeToPublicExternalStorage() {
        if (isMediaOK()) {
            File file = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    , "MyPublicExternalFile.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Welcome to the Public External Storage".getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else showToast(getResources().getString(R.string.bad_media));
    }


    private void readFromPublicExternalStorage() {
        if (isMediaOK()) {
            File file = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    , "MyPublicExternalFile.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder stringBuilder = new StringBuilder();

                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else
                        stringBuilder.append((char) ch);
                }
                fis.close();

                ((TextView) findViewById(R.id.TxtView1)).setText(stringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else showToast(getResources().getString(R.string.bad_media));
    }

    private void writeToAppPrivateExternalStorage() {
        if (isMediaOK()) {
            File file = new File(getExternalFilesDir(""), "MyAppPrivateExternalFile.txt");

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Welcome to the App Private External Storage".getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else showToast(getResources().getString(R.string.bad_media));
    }

    private void readFromAppPrivateExternalStorage() {
        if (isMediaOK()) {
            File file = new File(getExternalFilesDir(""), "MyAppPrivateExternalFile.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
                StringBuilder stringBuilder = new StringBuilder();

                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else
                        stringBuilder.append((char) ch);
                }
                fis.close();

                ((TextView) findViewById(R.id.TxtView2)).setText(stringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else showToast(getResources().getString(R.string.bad_media));
    }

    private void importanatUtilityMethods() {

        StringBuilder stringBuilder = new StringBuilder();
        String getCache_Dir = getCacheDir().getAbsolutePath();
        String getPrivatefiles_Dir = getExternalFilesDir("my").getAbsolutePath();
        String getPublicfiles_Dir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        stringBuilder.append("Cache Dir --> ").append(getCache_Dir).append("\n")
                .append("Private files Dir --> ").append(getPrivatefiles_Dir).append("\n")
                .append("Public files Dir --> ").append(getPublicfiles_Dir);

        ((TextView) findViewById(R.id.TxtView)).setText(stringBuilder.toString());

        Log.i("@ExternalStorage", "Cache Dir --> " + getCache_Dir);
        //  /data/data/com.example.a191externalstorage/cache
        Log.i("@ExternalStorage", "Private files Dir --> " + getPrivatefiles_Dir);
        //  /storage/emulated/0/Android/data/com.example.a191externalstorage/files/my
        Log.i("@ExternalStorage", "Public files Dir --> " + getPublicfiles_Dir);
        //  /storage/emulated/0/Download

    }

    private Boolean isMediaOK() {
        return Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
