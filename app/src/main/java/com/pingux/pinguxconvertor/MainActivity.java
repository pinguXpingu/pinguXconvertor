package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo=findViewById(R.id.pinguXlogo);
        Spinner selector=findViewById(R.id.spinner);
        Button selected=findViewById(R.id.button);

        String[] selectorArray=new String[] {
                "Mile <-> Km",
                "Feet <-> M",
                "mAh <-> Wh",
                "Knot <-> Km",
                "String tools",
        };
        ArrayAdapter<String> spinnerFiller=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selectorArray);
        spinnerFiller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(spinnerFiller);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context con=getApplicationContext();
                CharSequence msg="©pinguX™";
                int dur= Toast.LENGTH_SHORT;

                Toast t=Toast.makeText(con,msg,dur);
                t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                t.show();
            }
        });

        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel = (int) selector.getSelectedItemId();
                switch (sel){
                    case 0:
                        Intent ml=new Intent(MainActivity.this,mile2km.class);
                        startActivity(ml);
                        break;
                    case 1:
                        Intent mah=new Intent(MainActivity.this,feet2m.class);
                        startActivity(mah);
                        break;
                    case 2:
                        Intent knot=new Intent(MainActivity.this,mah2wh.class);
                        startActivity(knot);
                        break;
                    case 3:
                        Intent feet=new Intent(MainActivity.this,knot2km.class);
                        startActivity(feet);
                        break;
                    case 4:
                        Intent str=new Intent(MainActivity.this,stringtools.class);
                        startActivity(str);
                        break;
                    default:
                        Context con=getApplicationContext();
                        CharSequence msg="Bir hata meydana geldi™";
                        int dur= Toast.LENGTH_SHORT;
                        Toast t=Toast.makeText(con,msg,dur);
                        t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                        t.show();
                }
            }
        });
    }
}