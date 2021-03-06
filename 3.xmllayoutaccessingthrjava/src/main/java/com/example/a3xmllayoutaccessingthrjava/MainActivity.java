package com.example.a3xmllayoutaccessingthrjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*----------------  Way 1 ---------------------------------- */

    public void Submit(View view) {

        EditText EdtTxt = (EditText) findViewById(R.id.Edt_Txt);
        TextView TxtUpper = (TextView) findViewById(R.id.Txt_Upper);

        String name = String.valueOf(EdtTxt.getText());
        Log.v("XmlAccessJava", "GetName :" + name);
        TxtUpper.setText(name.toUpperCase());

    }

    public void Revert(View view) {
        EditText EdtTxt = (EditText) findViewById(R.id.Edt_Txt);
        TextView TxtVew = (TextView) findViewById(R.id.Txt_Lower);

        String name = EdtTxt.getText().toString();
        Log.v("XmlAccessJava", "GetName :" + name);
        TxtVew.setText(name.toLowerCase());

    }

    public void Reset(View view) {
        EditText EdtTxt = (EditText) findViewById(R.id.Edt_Txt);
        TextView TxtUpper = (TextView) findViewById(R.id.Txt_Upper);
        TextView TxtLower = (TextView) findViewById(R.id.Txt_Lower);

        EdtTxt.setText("");
        TxtUpper.setText("");
        TxtLower.setText("");
        Log.v("XmlAccessJava", "Reset  : " + " EdtTxt = " + EdtTxt + "Txt_Upper =" + TxtUpper + "Txt_Lower =" + TxtLower);
    }


    /*----------------  Way 2 ---------------------------------- */


    private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            TextView textUpper =
                    (TextView) findViewById(R.id.Txt_Upper);

            EditText edtTxt = // obj created by setContentView
                    (EditText) findViewById(R.id.Edt_Txt);

            if (v.getId() == R.id.Btn_Submit) {

                String name = edtTxt
                        .getText()
                        .toString();

                textUpper.setText(name.toUpperCase());
            } else {

                String name = edtTxt
                        .getText()
                        .toString();

                textUpper.setText(name.toLowerCase());
            }
        }
    }

    /*----------------  Way 3 ---------------------------------- */
    private class Click1 implements View.OnClickListener {

        public void onClick(View view) {
            Log.v("@XmlAccessJava", "Btn_Submitt");
            switch (view.getId()) {
                case R.id.Btn_Submit:
                    Log.v("@XmlAccessJava", "Btn_Submit");
                    EditText EdtTxt = (EditText) findViewById(R.id.Edt_Txt);
                    Log.v("@XmlAccessJava", "Btn_Submit1");
                    TextView TxtUpper = (TextView) findViewById(R.id.Txt_Upper);
                    Log.v("@XmlAccessJava", "Btn_Submit2");
                    String name = EdtTxt.getText().toString();
                    Log.v("@XmlAccessJava", "Btn_Submit3");
                    TxtUpper.setText(name.toUpperCase());
                    break;

                case R.id.Btn_Revert:

                    EditText EdtTxt1 = (EditText) findViewById(R.id.Edt_Txt);
                    TextView TxtLower1 = (TextView) findViewById(R.id.Txt_Lower);
                    String name1 = EdtTxt1.getText().toString();
                    TxtLower1.setText(name1.toLowerCase());
                    break;

                case R.id.Btn_Reset:

                    EditText EdtTxt2 = (EditText) findViewById(R.id.Edt_Txt);
                    TextView TxtUpper2 = (TextView) findViewById(R.id.Txt_Upper);
                    TextView TxtLower2 = (TextView) findViewById(R.id.Txt_Lower);
                    EdtTxt2.setText("");
                    TxtUpper2.setText("");
                    TxtLower2.setText("");
                    break;
            }

        }
    }
}
