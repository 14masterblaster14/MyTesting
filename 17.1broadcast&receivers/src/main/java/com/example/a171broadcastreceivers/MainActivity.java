package com.example.a171broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("@BroadcstReceivers", "Airplane mode changed" + intent.getBooleanExtra("state", false));

            if (intent.getBooleanExtra("state", false)) {
                //Enabled
                changeAirPlane(R.drawable.ic_airplanemode_active_black_24dp);
            } else {
                //Disabled
                changeAirPlane(R.drawable.ic_airplanemode_inactive_black_24dp);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    private void changeAirPlane(int image) {
        ((ImageView) findViewById(R.id.imageAirPlane)).setImageResource(image);

    }

}
