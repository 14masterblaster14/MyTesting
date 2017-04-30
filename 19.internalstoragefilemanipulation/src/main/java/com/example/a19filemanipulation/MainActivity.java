package com.example.a19filemanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Btn_Save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                writeToInternalStorage();
            }
        });

        findViewById(R.id.Btn_Display).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromInternalStorage();
            }
        });

        findViewById(R.id.Btn_ShowImpMthd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                importanatUtilityMethods();
            }
        });
    }

    private void writeToInternalStorage() {

        try {

            FileOutputStream fos = openFileOutput("myFile.txt", MODE_PRIVATE);
            fos.write("Welcome to Android Internal Storage".getBytes());
            fos.close();
            Log.i("@InternalStorage", "File wrote successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readFromInternalStorage() {

        try {

            /*
            // Java Way :(It is acheived in android by "openFileInput" method
            File file = new File(getFilesDir(),"myFile.txt");
            FileInputStream fis = new FileInputStream(file);
            */

            //  Android Way :
            FileInputStream fis = openFileInput("myFile.txt");
            StringBuilder stringBuilder = new StringBuilder();

            while (true) {
                int ch = fis.read();
                if (ch == -1) break;   //EOF
                else
                    stringBuilder.append((char) ch);
            }

            ((TextView) findViewById(R.id.TxtView)).setText(stringBuilder.toString());

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void importanatUtilityMethods() {

        StringBuilder stringBuilder = new StringBuilder();
        String cache_Dir = getCacheDir().getAbsolutePath();
        String files_Dir = getFilesDir().getAbsolutePath();
        String get_Dir = getDir("myFile.txt", MODE_APPEND).getPath();
        stringBuilder.append("Cache Dir --> ").append(cache_Dir).append("\n")
                .append("Files Dir --> ").append(files_Dir).append("\n")
                .append("getDir --> ").append(get_Dir);

        ((TextView) findViewById(R.id.TxtView1)).setText(stringBuilder.toString());

        String[] fileNames = fileList();
        for (String fileName : fileNames) {
            ((TextView) findViewById(R.id.TxtView1)).append("\n" + fileName);
            Log.i("@InternalStorage", "File Names - " + fileName);
            //File Names - instant-run
            //File Names - myFile.txt
        }

        // deleteFile("mYFile.txt");
        Log.i("@InternalStorage", "getCacheDir - " + cache_Dir);
        //getCacheDir - /data/data/com.example.a19filemanipulation/cache
        Log.i("@InternalStorage", "getFilesDir - " + files_Dir);
        //getFilesDir - /data/data/com.example.a19filemanipulation/files
        Log.i("@InternalStorage", "getDir - " + get_Dir);
        //getDir - /data/data/com.example.a19filemanipulation/app_myFile.txt
    }

}
