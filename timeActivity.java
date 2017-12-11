package com.example.kennethflores.ec_327_androidapp_updated;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class timeActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    String SelectedTime;
    Button bacActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner time = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(timeActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Hours));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(myAdapter);



        bacActivity = (Button)findViewById(R.id.button);
        time.setOnItemSelectedListener(this);
        bacActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(timeActivity.this,bacActivity.class);
                startActivity(myintent);




                try {
                    FileOutputStream fos = openFileOutput("Time", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(SelectedTime)).getBytes());
                    fos.close();
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SelectedTime = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}





