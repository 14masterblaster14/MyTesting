package com.example.a15interactivitycommunication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_COLOR_MAIN = "mainColor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        changeColor();

        findViewById(R.id.BtnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        /*        processSimpleBack(); */
                processResponseBack();
            }
        });
    }

    private void changeColor() {

        Intent resposibleIntent = getIntent();
        Bundle bundle = resposibleIntent.getExtras();

        if (bundle != null) {

            String color = bundle.getString(MainActivity.KEY_NEXT_COLOR);

            if (color.equals("Red")) {

                findViewById(R.id.RelativeNext).setBackgroundColor(Color.RED);
            } else {
                findViewById(R.id.RelativeNext).setBackgroundColor(Color.GREEN);
            }

        }
    }

    private void processSimpleBack() {

       /* CheckBox checkBox = (CheckBox) findViewById(R.id.ChkboxChng); */

        Intent intent = new Intent(NextActivity.this, MainActivity.class);

        startActivity(intent);
    }

    private void processResponseBack() {

        CheckBox checkbox = (CheckBox) findViewById(R.id.ChkboxChng);

        Intent intent = new Intent();

        Bundle bundle = new Bundle();

        bundle.putString(KEY_COLOR_MAIN, checkbox.isChecked() ? getCurrentColor() : "none");

        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);

        finish();

    }

    private String getCurrentColor() {

        String color = "none";

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();

        if (bundle != null) {

            color = bundle.getString(MainActivity.KEY_NEXT_COLOR);
        }

        return color;
    }
}
