package com.example.androidpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button map,dial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        map = (Button)findViewById(R.id.map);
        dial = (Button)findViewById(R.id.dial);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+et1.getText().toString()));
                startActivity(map);
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+et1.getText().toString()));
                startActivity(dial);
            }
        });
    }
}