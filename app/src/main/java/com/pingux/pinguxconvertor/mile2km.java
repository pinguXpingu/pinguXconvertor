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

import static android.text.TextUtils.*;

public class mile2km extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mile2km);

        Button mil2km_button=findViewById(R.id.mile2km_convertor);
        EditText mil_Text=(EditText)findViewById(R.id.mile_Text);
        EditText km_Text=(EditText) findViewById(R.id.km_Text);


        final String[] value = new String[1];
        DecimalFormat df=new DecimalFormat("0.000");

        mil_Text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                value[0] ="m";
                return false;
            }
        });

        km_Text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                value[0]="k";
                return false;
            }
        });


        mil2km_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty(mil_Text.getText().toString()) && isEmpty(km_Text.getText().toString())){
                    Context contxt=getApplicationContext();
                    CharSequence msg="No input";
                    int duration= Toast.LENGTH_SHORT;

                    Toast t=Toast.makeText(contxt,msg,duration);
                    t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                    t.show();
                }
                else{
                    if (value[0]=="m"){
                        km_Text.setText (String.valueOf(df.format(Float.parseFloat(mil_Text.getText().toString())/0.621)));
                    }
                    else if(value[0]=="k"){
                        mil_Text.setText(String.valueOf(df.format(Float.parseFloat((km_Text.getText().toString()))*0.621)));
                    }
                }
            }
        });
    }
}