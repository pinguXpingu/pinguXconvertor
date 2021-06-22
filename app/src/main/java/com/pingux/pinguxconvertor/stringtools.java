package com.pingux.pinguxconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class stringtools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stringtools);

        Spinner selector = findViewById(R.id.spinner_crypt);

        String[] strselectorsArray = new String[]{
                "String <-> binary",
                "String <-> base64",
                "String <-> base32",
                "String ->> sha256",
                "String ->> sha512",
                "String ->> md5",

        };
        ArrayAdapter<String> spinnerFiller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strselectorsArray);
        spinnerFiller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(spinnerFiller);

    }
}