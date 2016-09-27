package com.example.a31uicontrols;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String edittextinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // My Code starts here -->>

        EditText editText = (EditText) findViewById(R.id.EdtTxt);
        edittextinput = editText.getText().toString();
        Log.v("@UIControl", "edittextinput :" + edittextinput);

        findViewById(R.id.Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = (TextView) findViewById(R.id.TxtView);
                textView.setText(edittextinput);
            }
        });

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.AutoTxtView);
        ArrayList<String> sex = new ArrayList<>();
        sex.add("MALE");
        sex.add("FEMALE");
        sex.add("OTHERS");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, sex);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        String Selection = String.valueOf(autoCompleteTextView.getListSelection());
        Log.v("@UIControl", "AutoCompleteTextView Selection :" + Selection);
        TextView textView = (TextView) findViewById(R.id.TxtView);
        textView.setText(Selection);


        Switch mySwitch = (Switch) findViewById(R.id.Switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    findViewById(R.id.TxtView).setBackgroundColor(400);
                 /*   TextView switchTxtView = (TextView) findViewById(R.id.TxtView);
                    switchTxtView.setBackgroundColor(500); */
                    Log.v("@UIControl", "Current Switch Status :" + "Checked");
                } else {
                    Log.v("@UIControl", "Current Switch Status :" + "Non Checked");
                }
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.RtngBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Log.v("@UIControl", "Current Rating is :" + rating);
                ((TextView) findViewById(R.id.TxtView)).setText("Current Rating is " + String.valueOf(rating));
            }
        });


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
        // My Code Ends here -->>
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
