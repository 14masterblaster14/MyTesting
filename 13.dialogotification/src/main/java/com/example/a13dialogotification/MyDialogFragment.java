package com.example.a13dialogotification;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE_PICKER = "datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS_DIALOG = "progress";
    public static final String TAG_CUSTOM = "custom";

    /*
    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }
    */


    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if (getTag().equals(TAG_ALERT))
            dialog = createAlertDialog();

        else if (getTag().equals(TAG_DATE_PICKER))
            dialog = createDatePickerDialog();

        else if (getTag().equals(TAG_TIME_PICKER))
            dialog = createTimePickerDialog();

        else if (getTag().equals(TAG_PROGRESS_DIALOG))
            dialog = createProgressDialog();

        else dialog = createCustomDialog();

        return dialog;


    }

    private AlertDialog createAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Alert Dialog")
                .setMessage("Message: This is Alert.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }

    private DatePickerDialog createDatePickerDialog() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        showToast("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, 2016, 12, 21);
        return datePickerDialog;
    }

    private TimePickerDialog createTimePickerDialog() {

        TimePickerDialog timePickerDiaog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                showToast("" + hourOfDay + ":" + minute);
            }
        }, 12, 57, true);
        return timePickerDiaog;
    }
    //Android includes another dialog class called ProgressDialog that shows a dialog with a progress bar.
    // However, if you need to indicate loading or indeterminate progress, you should instead follow the
    // design guidelines for Progress & Activity and use a ProgressBar in your layout.

    private ProgressDialog createProgressDialog() {

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Title : Progress Bar");
        progressDialog.setMessage("Message : Hi");

        return progressDialog;
    }

    private AlertDialog createCustomDialog() {

        LayoutInflater inflator = getActivity().getLayoutInflater();

        View myView = inflator.inflate(R.layout.fragment_my_dialog, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(myView);

        myView.findViewById(R.id.America).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("America");
            }
        });

        return builder.create();
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
