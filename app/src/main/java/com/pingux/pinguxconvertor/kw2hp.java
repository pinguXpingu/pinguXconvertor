package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.text.TextUtils.*;

public class kw2hp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kw2hp);

        EditText kwEntry = (EditText) findViewById(R.id.kwEntry);
        EditText hpEntry = (EditText) findViewById(R.id.hpEntry);
        Button convertButton = (Button) findViewById(R.id.kw2hpConvertor);

        final String[] value = new String[1];
        DecimalFormat df=new DecimalFormat("0.000");

        kwEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                value[0] = "k";
                return false;
            }
        });

        hpEntry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                value[0] = "h";
                return false;
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(kwEntry.getText().toString()) && isEmpty(hpEntry.getText().toString())){
                    Context contxt=getApplicationContext();
                    CharSequence msg="No input";
                    int duration= Toast.LENGTH_SHORT;

                    Toast t=Toast.makeText(contxt,msg,duration);
                    t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                    t.show();
                }
                else {
                    if (value[0] == "k"){
                        hpEntry.setText(df.format(Float.parseFloat(kwEntry.getText().toString())/0.745699872));
                    } else if (value[0] == "h") {
                        kwEntry.setText(df.format(Float.parseFloat(hpEntry.getText().toString())*0.745699872));
                    }
                }
            }
        });
    }
}