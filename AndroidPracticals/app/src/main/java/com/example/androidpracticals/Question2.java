package com.example.androidpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    DatabaseHelper db;
    EditText name, company, designation, location;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        db = new DatabaseHelper(this);
        name = (EditText)findViewById(R.id.name);
        company = (EditText)findViewById(R.id.company);
        designation = (EditText)findViewById(R.id.designation);
        location = (EditText)findViewById(R.id.location);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a, b, c, d;
                a = name.getText().toString();
                b = company.getText().toString();
                c = designation.getText().toString();
                d = location.getText().toString();

                if (a.equals("") || b.equals("") || c.equals("") || d.equals("")) {
                    Toast.makeText(getApplicationContext(), "Text box is empty", Toast.LENGTH_LONG).show();
                } else {

                    boolean result = db.insertDate(name.getText().toString(),
                            company.getText().toString(),
                            designation.getText().toString(),
                            location.getText().toString());
                    if (result == true)
                        Toast.makeText(Question2.this, "Record inserted successfully", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Question2.this, "Record not inserted",
                                Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}