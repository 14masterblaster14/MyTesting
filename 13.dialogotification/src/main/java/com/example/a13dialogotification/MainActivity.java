package com.example.a13dialogotification;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Btn_Alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Simple Dialog without fragment --> Not Recommended
                // showDialog();
                //Simple Dialog with fragment
                showDialog(MyDialogFragment.TAG_ALERT);

            }
        });

        findViewById(R.id.Btn_DatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_DATE_PICKER);
            }
        });

        findViewById(R.id.Btn_TimePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_TIME_PICKER);
            }
        });

        findViewById(R.id.Btn_Progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_PROGRESS_DIALOG);
            }
        });

        findViewById(R.id.Btn_Custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_CUSTOM);
            }
        });


      /*  findViewById(R.id.SelectCountry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButtonAmerica = (RadioButton) findViewById(R.id.America);
                showToast(radioButtonAmerica.isChecked() ? "America" : "China");
           }
        });  */

      /*
        RadioButton radioButtonAmerica = (RadioButton) findViewById(R.id.America);
        showToast(radioButtonAmerica.isChecked() ? "America" : "China");
        */
    }

    private void showDialog() //--> Not Recommended
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setMessage("Simple Alert Dialog")
                .setTitle("Title");
        AlertDialog dialog = builder.create();
        dialog.show();
    } //--> Not Recommended

    private void showDialog(String tag) {

        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(), tag);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}