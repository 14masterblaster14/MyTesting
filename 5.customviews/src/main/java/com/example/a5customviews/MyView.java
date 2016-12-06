package com.example.a5customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by comp on 11/30/2016.
 */

public class MyView extends TextView {
    private Paint paint;
    private int x, y, dx = 5, dy = 5;

    public MyView(Context context) {
        super(context);
        // create view in java code

        initPaint();

        startBouncing();
    }

    public MyView(Context context, AttributeSet attr) {
        super(context, attr);
        // create view in xml

        initPaint();

        startBouncing();
    }

    private void startBouncing() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    if (x >= getWidth()) dx = -5;
                    if (x <= 0) dx = 5;
                    if (y >= getHeight()) dy = -5;
                    if (y <= 0) dy = 5;

                    x += dx;
                    y += dy;

                    invalidate(); // async task
                }
            }
        }).start();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(130);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, y, 30, paint);
        //canvas.drawText("{code}kul;",70,70,paint);
        //canvas.drawLine(10,10,90,90,paint);
    }
}