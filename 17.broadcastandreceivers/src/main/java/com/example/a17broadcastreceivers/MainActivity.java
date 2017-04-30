package com.example.a17broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

// Case1 : When we want to receive the broadcasts when our app is active
// Don't include the "receiver" tag in manifest file and don't use the MyReceiver class as well
/*
public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("@BroadcstReceivers", "Airplane mode changed : " + intent.getBooleanExtra("state", false));

            if (intent.getBooleanExtra("state", false)) {
                //Enabled
                changeAirPlane(R.drawable.ic_airplanemode_active_black_24dp);
            } else {
                //Disabled
                changeAirPlane(R.drawable.ic_airplanemode_inactive_black_24dp);
            }
        }
        };

        private void changeAirPlane(int image) {
            ((ImageView) findViewById(R.id.imageAirPlane)).setImageResource(image);

        }

    }
    */
// Case2 : When we want to receive the broadcasts irrespective of our app is on/off.
//i.e. throughout your app life cycle install-->Uninstall
// Use the "receiver" tag in manifest file and class "MyReceiver"
//*
public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnFireBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendBroadcast(new Intent("android.intent.action.CUSTOM_RECEIVER"));
            }
        });

    }
}
//*/




