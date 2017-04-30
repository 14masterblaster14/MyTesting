package com.example.a11toastnotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          /*      Toast toast = Toast.makeText(MainActivity.this,"This is a Toast",Toast.LENGTH_SHORT);
                toast.show(); */

                Toast.makeText(MainActivity.this, "Hi Dear, this is a toast", Toast.LENGTH_SHORT).show();

                /* We can set a button for toast view */

           /*     Toast toast = Toast.makeText(MainActivity.this,"This is toast",Toast.LENGTH_SHORT);

                  toast.setView(new Button(MainActivity.this));
                  toast.setView(new ImageView(MainActivity.this));
                  toast.show(); */

            }
        });
    }
}
