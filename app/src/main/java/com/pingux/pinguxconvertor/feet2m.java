package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.text.TextUtils.isEmpty;

public class feet2m extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feet2m);

        EditText feetEntry=(EditText)findViewById(R.id.feetEntry);
        EditText mtEntry=(EditText)findViewById(R.id.mtEntry);
        Button feetButton=(Button)findViewById(R.id.feetConvertor);

        final String val[]=new String[1];
        DecimalFormat formatter=new DecimalFormat("0.00");

        feetEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                val[0]="f";
                return false;
            }
        });

        mtEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                val[0]="m";
                return false;
            }
        });

        feetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(feetEntry.getText().toString()) && isEmpty(mtEntry.getText().toString())){
                    tostViewer("No Input");
                }
                else{
                    switch (val[0]){
                        case "f":
                            mtEntry.setText(formatter.format(Float.parseFloat(feetEntry.getText().toString())*0.3048));
                            break;
                        case "m":
                            feetEntry.setText(formatter.format(Float.parseFloat(mtEntry.getText().toString())*3.2808399));
                            break;
                        default:
                            tostViewer("Unknown Error!");
                    }
                }
            }
        });
    }

    private void tostViewer(String toastMsg){
        Context mesaj=getApplicationContext();
        CharSequence msg=toastMsg;
        int duration= Toast.LENGTH_SHORT;

        Toast tost=Toast.makeText(mesaj,msg,duration);
        tost.setGravity(Gravity.CENTER,0,0);
        tost.show();
    }
}