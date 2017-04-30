package com.example.a211contentproviderusage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> records = new ArrayList<>();
        Uri uri = Uri.parse("content://com.sampleuriauthorities.provider");

        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        while (cursor.moveToNext()) {

            String userName = cursor.getString(cursor.getColumnIndex("UserName"));
            Integer rollNo = cursor.getInt(cursor.getColumnIndex("RollNo"));

            Log.i("@MasterBlaster", "UserName - " + userName + "RollNo - " + rollNo);
            records.add(userName + "\n" + rollNo);
        }

        ((ListView) findViewById(R.id.ListRecords))
                .setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, records));

    }
}
