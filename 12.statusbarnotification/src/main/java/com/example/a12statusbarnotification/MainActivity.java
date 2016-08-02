package com.example.a12statusbarnotification;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/* INCLUDE Notification activity in Manifest file */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Btn_Notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNotification();
            }
        });
    }

    private void showNotification() {

        Intent intent = new Intent(this, NotificationActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivities(this
                , 1234
                , intent
                , PendingIntent.FLAG_UPDATE_CURRENT);


    }
}
