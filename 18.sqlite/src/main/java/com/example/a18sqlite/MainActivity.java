package com.example.a18sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper dbHelper = new DbHelper(this, "My.SqlDb", null, 1);
        /* My.SqlDb --> Unique DB name for your application*/

        findViewById(R.id.BtnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

                String table = "UserTable";
                String nullColumnHack = null;
                /*nullColumnHack --> Specify the column name which can consist of null value.
                                     Here null means every column should have some value */
                ContentValues values = new ContentValues();
                values.put("UserName", getUserName());
                values.put("RollNo", getRollNo());
                sqlDb.insert(table, nullColumnHack, values);

                sqlDb.close();
            }
        });
    }


    private String getUserName() {

        return ((EditText) findViewById(R.id.EdtUsrName))
                .getText()
                .toString();
    }

    private String getRollNo() {

        return ((EditText) findViewById(R.id.EdtRollNo))
                .getText()
                .toString();
    }

}
