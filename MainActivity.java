package com.parkingtracer.simon.parkingtracer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button, allbtn;
    String getValue;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // inializing components------------------------------
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        allbtn = (Button) findViewById(R.id.button2);

        //!-------------------- initializing components
        String str = editText.getText().toString();


            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getValue = editText.getText().toString();
                     if (getValue.isEmpty()) {
                         Snackbar.make(v, "Please Enter your parking address into the field ", Snackbar.LENGTH_LONG)
                                 .setAction("Action", null).show();
                     }
                     else{


                         Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                         intent.putExtra("value", getValue);
                         startActivity(intent);
                     }

                }

            });




        allbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("value", "all");
                startActivity(intent);

            }

        });

    }
}


