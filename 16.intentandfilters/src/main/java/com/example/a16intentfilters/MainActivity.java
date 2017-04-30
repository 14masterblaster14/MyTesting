package com.example.a16intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check();
                //    openAllApps();
                //    dial();
                //    call();
            }
        });
    }

    private void check() {

        Intent intent = new Intent(); // Default Category
        intent.setAction("com.codekul.action.Common");
        intent.setData(Uri.parse("http://codekul.com")); //***
        startActivity(intent);
    }
    // Case 1 ( w/o "//***" statement) : It will fetch all three intent filters and gives the dialog
    //                                   "Complete action using" with "Just Once" or "Always" options.
    //Case 1 ( with "//***" statement) : It will open <activity android:name=".NextActivity" > as
    //                                   we have specified scheme here which is explicit identifier
    // "http://" is the scheme used here.

    private void openAllApps() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER); //***
        startActivity(intent);
    }
    // It will fetch all the application (***which has launchers application) in ur phone and
    // gives the dialog "Complete action using" with "Just Once" or "Always" options.

    private void dial() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    // It will fetch the Any_other activity.

    private void call() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9820857225"));
        startActivity(intent);
    }
    // It will fetch the Next activity.
    //"tel://" is the scheme used here.
}
