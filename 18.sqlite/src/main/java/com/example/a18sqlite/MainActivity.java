package com.example.a18sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                Log.i("sqlite", "UserName :" + getUserName());
                Log.i("sqlite", "RollNo :" + getRollNo());
                sqlDb.insert(table, nullColumnHack, values);

                sqlDb.close();
            }
        });


        findViewById(R.id.BtnQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqlDb = dbHelper.getReadableDatabase();

                String table = "UserTable";
                String[] columns = {"UserName"};
                /* String[] columns = null; */
                /* columns --> columns to be return from query and displayed.
                               Null will return all columns.                    */

                String selection = "rollNo = ?";
                /* selection --> filter for which rows to return.
                 *               Null will return all data i.e. Select * */

                String[] selectionArgs = {getRollNo()};
                /* selectionArgs --> It will replace the $ in selection clause
                                    Null will return all data i.e. Select * */

                String groupBy = null;
                String having = null;
                String orderBy = null;

                Cursor cursor = sqlDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

                while (cursor.moveToNext()) {

                    String userName = cursor.getString(0);
                    /*0--> Column index*/
                    /* int rollNo = cursor.getInt(cursor.getColumnIndex("RollNo")); */

                    Log.i("sqlite", "UserName : " + userName);

                }

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
