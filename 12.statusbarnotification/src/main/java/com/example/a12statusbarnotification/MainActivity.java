package com.example.a12statusbarnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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

        Intent intent =
                new Intent(this, NotificationActivity.class);

        PendingIntent contentIntent =
                PendingIntent.getActivity(this,
                        1234,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder
                = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentTitle("Title")
                .setContentInfo("Info")
                .setContentText("Text")
                .setContentIntent(contentIntent)
                .setTicker("Ticker")
                .setDefaults(Notification.DEFAULT_ALL)
                .addAction(R.mipmap.ic_launcher, "Reply", contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();
        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1222, notification);

    }
}
