package com.example.a32uicontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.NoPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(9);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                Log.v("@UIControl", " NumberPicker Old Value :" + oldVal);
                Log.v("@UIControl", " NumberPicker New Value :" + newVal);
            }
        });

        TimePicker timePicker = (TimePicker) findViewById(R.id.TmPicker);
        /*int hour = timePicker.getHour();
        int min = timePicker.getMinute(); */
    }
}
