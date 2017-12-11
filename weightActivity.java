package com.example.kennethflores.ec_327_androidapp_updated;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class weightActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button NextButton;
    private EditText inputWeight;
    //private Spinner whichUnit;
    double weight;
    int unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputWeight = (EditText) findViewById(R.id.editText2);
        final Spinner whichUnit = (Spinner) findViewById(R.id.spinner);
        NextButton = (Button) findViewById(R.id.button6);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(weightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.country_arrays));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        whichUnit.setAdapter(myAdapter);

        whichUnit.setOnItemSelectedListener(this);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(weightActivity.this,drinksActivity.class);
                startActivity(myintent);

                weight = Double.valueOf(inputWeight.getText().toString());

                weight = calculateWeight();

                try {
                    FileOutputStream fos = openFileOutput("weight", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(weight)).getBytes());
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



   /* public void onClick(View view) {
        Intent myIntent = new Intent(weightActivity.this, drinksActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }*/

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        unit = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public double calculateWeight()
    {
        if(unit == 1)
        {
            weight = weight*1000;
        }
        else
        {
            weight = weight*0.453592*1000;
        }
        return weight;
    }
}
