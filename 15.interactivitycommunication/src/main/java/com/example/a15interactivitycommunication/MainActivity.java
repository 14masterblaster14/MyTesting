package com.example.a15interactivitycommunication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    /*
    * 1. Simply starting new activity
    * 2. Sending data to new activity
    * 3. Getting data in new activity
    * 4. Throwing data back from new activity to previous activity
     */
    public static final String KEY_NEXT_COLOR = "color";
    public static final int REQ_NEXT_ID = 1234;

    /*------------------------ If Next Activity w/o any response collection ---------------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NextActivity.class);

                // 1. Simply starting new activity
                //     startActivity(intent);


                // 2. Sending data to new activity
                RadioButton radioButton = (RadioButton) findViewById(R.id.RadioRed);
                Bundle bundle = new Bundle();
                bundle.putString(KEY_NEXT_COLOR, radioButton.isChecked() ? "Red" : "Green");

                intent.putExtras(bundle);
                //startActivity(intent);

                //4. Expecting the response from the next activity

                startActivityForResult(intent, REQ_NEXT_ID);

            }
        });
    }

    /*------------------------ If Next Activity with some response collection ---------------------*/

    protected void onActivityResult(int requestID, int resultID, Intent data) {

        super.onActivityResult(requestID, resultID, data);

        if (requestID == REQ_NEXT_ID) {

            if (resultID == RESULT_OK) {

                if (data != null) {

                    Bundle bundle = data.getExtras();
                    String color = bundle.getString(NextActivity.KEY_COLOR_MAIN);

                    if (!color.equals("none")) {

                        if (color.equals("Red")) {
                            findViewById(R.id.MainActLayout).setBackgroundColor(Color.RED);
                        } else {
                            findViewById(R.id.MainActLayout).setBackgroundColor(Color.GREEN);
                        }
                    }
                }
            }

        }
    }

}

