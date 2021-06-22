package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.text.TextUtils.isEmpty;

public class knot2km extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knot2km);

        EditText knotEntry=(EditText)findViewById(R.id.knotEntry);
        EditText kmhEntry=(EditText)findViewById(R.id.kmhEntry);
        Button convertButton=(Button)findViewById(R.id.knotConvertor);

        final String value[]=new String[1];
        DecimalFormat df=new DecimalFormat("0.00");

        knotEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                value[0]="n";
                return false;
            }
        });

        kmhEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                value[0]="m";
                return false;
            }
        });


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(knotEntry.getText().toString()) && isEmpty(kmhEntry.getText().toString())){
                    Context mesaj=getApplicationContext();
                    CharSequence msg="No Input";
                    int duration= Toast.LENGTH_SHORT;

                    Toast tost=Toast.makeText(mesaj,msg,duration);
                    tost.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                    tost.show();
                }
                else{
                    if(value[0]=="n"){
                        kmhEntry.setText(df.format(Float.parseFloat((knotEntry.getText().toString()))*1.852));
                    }
                    else if(value[0]=="m"){
                        knotEntry.setText(df.format(Float.parseFloat(kmhEntry.getText().toString())*0.53996));
                    }
                }
            }
        });
    }
}