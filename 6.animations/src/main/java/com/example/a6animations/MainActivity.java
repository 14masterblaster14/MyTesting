package com.example.a6animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnRotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animateView(R.anim.rotate);
            }
        });

        findViewById(R.id.BtnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateView(R.anim.custom);
            }
        });
    }

    private void animateView(int animation) {

        findViewById(R.id.ImgVw)
                .startAnimation(AnimationUtils
                        .loadAnimation(this, animation));

    }
}
