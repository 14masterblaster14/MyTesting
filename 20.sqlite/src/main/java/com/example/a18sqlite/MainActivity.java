package com.example.a18sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this, "My.SqlDb", null, 1);
        /* My.SqlDb --> Unique DB name for your application*/

        findViewById(R.id.BtnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

        findViewById(R.id.BtnQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querry();
            }
        });

        findViewById(R.id.BtnUpdt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        findViewById(R.id.BtnDelete).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                delete();
            }
        });

        findViewById(R.id.BtnRawInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRawSQL();
            }
        });

        findViewById(R.id.BtnShowTbl1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAll();
            }
        });

        findViewById(R.id.BtnShowTbl2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectRawSQL();
            }
        });
    }

    private void insert() {

        SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

        String table = "UserTable";
        String nullColumnHack = null;
                /*nullColumnHack --> For empty row ,specify the column name which can consist of null value.
                                     Here null means every column should have some value i.e. necessary.*/
        ContentValues values = new ContentValues();  // column to value mapping i.e. Hashmap
        values.put("UserName", getUserName());
        values.put("RollNo", getRollNo());
        Log.i("@sqlite", "UserName :" + getUserName());
        Log.i("@sqlite", "RollNo :" + getRollNo());
        sqlDb.insert(table, nullColumnHack, values);

        sqlDb.close();
    }

    private void querry() {

        SQLiteDatabase sqlDb = dbHelper.getReadableDatabase();

        String table = "UserTable";
        String[] columns = {"UserName"};
                /* String[] columns = null; */
                /* columns --> columns to be return from query and displayed.
                               Null will return all columns.                    */

        String selection = "rollNo = ?";
                /* selection --> filter for which rows to return i.e. where clause
                                 Null will return all data i.e. Select *
                    e.g. String selection = "rollNo = ? and UserName = ? ";
                        Here both columns are in the where clause.              */

        String[] selectionArgs = {getRollNo()};
                /* selectionArgs --> It will replace the ? in selection clause.
                                    Null will return all data i.e. Select *
                    e.g. String[] selectionArgs = {getRollNo(), getUserName()};
                        Here values will be returned in the same sequence.      */

        // String[] selectionArgs = {""+getRollNo()};      IF column is an Integer
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqlDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

        // while (cursor.moveToNext())
        // Use when you are fetching more than 1 row.

        if (cursor.moveToNext()) {

            String userName = cursor.getString(0);
                    /*0--> Column index*/
            // String rollNo = cursor.getString(1);
            // OR
            //String rollNo = cursor.getString(cursor.getColumnIndex("RollNo"));

            //Integer rollNo = cursor.getInt(cursor.getColumnIndex("RollNo")); IF column is an Integer
            Log.i("@sqlite", "UserName : " + userName);
            // Log.i("sqlite", "RollNo : " + rollNo);

            ((EditText) findViewById(R.id.EdtUsrName)).setText(userName);
            }
        sqlDb.close();

    }

    private void update() {

        SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

        String table = "UserTable";
        ContentValues values = new ContentValues();
        values.put("UserName", getUserName());
        String whereClause = "RollNo = ? ";
        String[] whereArgs = {getRollNo()};
        // String[] whereArgs = {String.valueOf(getRollNo())};      IF column is an Integer
        sqlDb.update(table, values, whereClause, whereArgs);

        sqlDb.close();
    }

    private void delete() {

        SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();

        String table = "UserTable";
        String whereClause = "RollNo = ?";
        String[] whereArgs = {getRollNo()};
        // String[] whereArgs = {String.valueOf(getRollNo())};      IF column is an Integer
        sqlDb.delete(table, whereClause, whereArgs);
        sqlDb.close();
    }

    private void displayAll() {

        SQLiteDatabase sqlDb = dbHelper.getReadableDatabase();

        String table = "UserTable";
                /* String[] columns = {"UserName"}; */
        String[] columns = null;
                /* columns --> columns to be return from query and displayed.
                               Null will return all columns.                    */

                /* String selection = "rollNo = ?"; */
        String selection = null;
                /* selection --> filter for which rows to return.
                 *               Null will return all data i.e. Select * */

                /* String[] selectionArgs = {getRollNo()}; */
        String[] selectionArgs = null;
                /* selectionArgs --> It will replace the $ in selection clause
                                    Null will return all data i.e. Select * */

        String groupBy = null;
        String having = null;
        String orderBy = "RollNo";
                /*  String orderBy = "RollNo Dsc"; */

        Cursor cursor = sqlDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

        ArrayList<String> dataset = new ArrayList<>();

        while (cursor.moveToNext()) {

            String userName = cursor.getString(0);
                    /*0--> Column index*/
                    /* int rollNo = cursor.getInt(cursor.getColumnIndex("RollNo")); */

            int rollno = cursor.getInt(1);

            Log.i("@sqlite", "UserName --> " + userName);
            Log.i("@sqlite", "RollNo --> " + rollno);

            dataset.add(userName + " --> " + rollno);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dataset);

        ((ListView) findViewById(R.id.ListView)).setAdapter(adapter);

        sqlDb.close();
    }

    private void selectRawSQL() {
        SQLiteDatabase sqlDb = dbHelper.getReadableDatabase();
        Cursor cursor = sqlDb.rawQuery("select * from UserTable", null);
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()) {
            String userName = cursor.getString(cursor.getColumnIndex("UserName"));
            String rollNo = cursor.getString(cursor.getColumnIndex("RollNo"));
            // int rollNo = cursor.getInt(cursor.getColumnIndex("RollNo")); IF column is an Integer
            Log.i("@sqlite", "User Name --> " + userName + "  " + "Roll No --> " + rollNo);
            stringBuilder.append("User : " + userName).append(", RollNo : " + rollNo).append("\n");
        }

        ((TextView) findViewById(R.id.TxtView)).setText(stringBuilder.toString());

        sqlDb.close();
    }

    private void insertRawSQL() {
        SQLiteDatabase sqlDb = dbHelper.getWritableDatabase();
        sqlDb.execSQL("Insert into UserTable values('RawAndroid',21)");
        sqlDb.close();
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

/*  If column value is an integer
    private Integer getRollNo() {
        return Integer.parseInt(((EditText) findViewById(R.id.EdtRollNo))
                .getText()
                .toString());
    }
*/

}
