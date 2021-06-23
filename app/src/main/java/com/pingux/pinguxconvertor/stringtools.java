package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Base64;

public class stringtools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stringtools);

        EditText stringText=findViewById(R.id.stringText);
        Spinner selector = findViewById(R.id.spinner_crypt);
        Button convertButton=findViewById(R.id.convertButton);
        Button copyButton=findViewById(R.id.copyButton);

        String[] strselectorsArray = new String[]{
                "String <-> Binary",
                "Binary <-> String",
                "String <-> Base64",
                "Base64 ->> String",

        };
        ArrayAdapter<String> spinnerFiller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strselectorsArray);
        spinnerFiller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(spinnerFiller);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sel=selector.getSelectedItem().toString();
                Editable txt=stringText.getText();
                switch (sel){
                    case "String <-> Binary":
                        stringText.setText(str2bin(txt.toString()));
                        break;
                    case "Binary <-> String":
                        stringText.setText(bin2str(txt.toString()));
                        break;
                    case "String <-> Base64":
                        stringText.setText(str2b64(txt.toString()));
                        break;
                    case "Base64 ->> String":
                        stringText.setText(b642str(txt.toString()));
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

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String copied=stringText.getText().toString();
                ClipboardManager clip=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData copiedClip=ClipData.newPlainText("text",copied);
                clip.setPrimaryClip(copiedClip);

                Context kontext=getApplicationContext();
                CharSequence msg=copied+" copied";
                int duration= Toast.LENGTH_SHORT;

                Toast t=Toast.makeText(kontext,msg,duration);
                t.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
                t.show();

            }
        });
    }
    private static String str2bin(String s){
        StringBuilder str=new StringBuilder();
        char[] chars=s.toCharArray();

        for(char aChar:chars) {
            str.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return str.toString();
    }

    private static String str2b64(String s){
        byte[] string2Bytes=s.getBytes();
        return Base64.getEncoder().encodeToString(string2Bytes);
    }

    private static String bin2str(String s){
        String[] ss = s.split( " " );
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < ss.length; i++ ) {
            sb.append( (char)Integer.parseInt( ss[i], 2 ) );
        }
        return sb.toString();
    }

    private static String b642str(String s){
        byte[] decoded = Base64.getDecoder().decode(s);
        return new String(decoded);
    }
}