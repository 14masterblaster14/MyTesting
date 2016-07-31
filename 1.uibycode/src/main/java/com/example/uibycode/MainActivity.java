package com.example.uibycode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //px = dp * (dpi / 160)

        //getWindow().setBackgroundDrawableResource(R.drawable.my);
        setContentView(R.layout.activity_main);

        // Every view needs context and layout parameters
        //View view = new View(this/*I was expecting object context and you passed object of Activity*/);

        LinearLayout layoutRoot =
                new LinearLayout(this);
        LinearLayout.LayoutParams paramsRoot =
                new LinearLayout.LayoutParams(300, 300);
        layoutRoot.setLayoutParams(paramsRoot);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams paramsEdtName =
                new LinearLayout.LayoutParams(300, 150);
        EditText edtName = new EditText(this);
        edtName.setLayoutParams(paramsEdtName);
        layoutRoot.addView(edtName);

        LinearLayout.LayoutParams paramsBtnOkay =
                new LinearLayout.LayoutParams(300, 150);
        Button btnOkay =
                new Button(this);
        btnOkay.setLayoutParams(paramsBtnOkay);
        layoutRoot.addView(btnOkay);

        setContentView(layoutRoot);
    }
}

