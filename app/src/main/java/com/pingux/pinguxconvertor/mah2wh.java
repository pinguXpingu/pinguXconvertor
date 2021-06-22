package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class mah2wh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mah2wh);

        Button convertor_button=findViewById(R.id.mah2wh_convertor);
        DecimalFormat df = new DecimalFormat("0.00");
        EditText mah=(EditText)findViewById(R.id.mAh_Text);
        EditText volt=(EditText)findViewById(R.id.volt_Text);
        EditText watt=(EditText)findViewById(R.id.watt_Text);
        watt.setFocusable(false);

        convertor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x=Float.parseFloat(mah.getText().toString());
                float y=Float.parseFloat(volt.getText().toString());
                float z=y*x/1000;
                watt.setText((String.valueOf(df.format(z))));
            }
        });
    }
}