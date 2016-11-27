package com.example.a32uicontrols;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int year, month, day, hours, minutes, am_pm;

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
                Log.v("@UIControl", " Selected Value :" + newVal);
            }
        });

        setCurrentDateOnView();

        DatePicker datePicker2 = (DatePicker) findViewById(R.id.DtPicker);

        setCurrentTimeOnView();

        TimePicker timePicker2 = (TimePicker) findViewById(R.id.TmPicker);
        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Log.v("@UIControl", " TimePicker Selected Hour Value :" + hourOfDay);
                Log.v("@UIControl", " TimePicker Selected Minutes Value :" + minute);
            }
        });

    }

    public void setCurrentDateOnView() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        Log.v("@UIControl", " DatePicker Default Year Value :" + year);
        Log.v("@UIControl", " DatePicker Default Month Value :" + month);
        Log.v("@UIControl", " DatePicker Default Day Value :" + day);

        DatePicker datePicker1 = (DatePicker) findViewById(R.id.DtPicker);
    }

    public void setCurrentTimeOnView() {

        Calendar calendar = Calendar.getInstance();
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        am_pm = calendar.get(Calendar.AM_PM);

        Log.v("@UIControl", " TimePicker Default Hour Value :" + hours);
        Log.v("@UIControl", " TimePicker Default Minutes Value :" + minutes);
        Log.v("@UIControl", " TimePicker Default AmPm Value :" + am_pm);

        TimePicker timePicker1 = (TimePicker) findViewById(R.id.TmPicker);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker1.setHour(hours);
            timePicker1.setMinute(minutes);

        }

    }
}
