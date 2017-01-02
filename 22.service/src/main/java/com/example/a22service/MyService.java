package com.example.a22service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.IOException;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(this, R.raw.whistle);
        mediaPlayer.start();
        return START_NOT_STICKY;
        //    return super.onStartCommand(intent, flags, startId);
        }

    /*    @Override
        public int onStartCommand(Intent intent, int flags, int startId){

              mediaPlayer = new MediaPlayer();
              File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "tu_Hai_Ki_Nahi_Whistle.mp3");


            try {
                mediaPlayer.setDataSource(file.getAbsolutePath());
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //return super.onStartCommand(intent, flags, startId);

            return START_NOT_STICKY;

        }
    */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // Mandatory method
        throw new UnsupportedOperationException("Not yet implemented");

        // return null;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}
