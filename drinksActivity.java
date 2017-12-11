package com.example.kennethflores.ec_327_androidapp_updated;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class drinksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private EditText inputAmountDrinks;


    String value = "";
    double ratio, volume;
    double amountInGrams;
    double amountOfDrinks;
    Button Repeat, Next;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inputAmountDrinks = (EditText) findViewById(R.id.inputDrinks);
        final Spinner TypeofAlc = (Spinner) findViewById(R.id.spinner2);

        Repeat = (Button) findViewById(R.id.button7);
        Next = (Button) findViewById(R.id.button8);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(drinksActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.BOOZE));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TypeofAlc.setAdapter(myAdapter);


        final String previousAmount = openFile("Alconsumed");
        TypeofAlc.setOnItemSelectedListener(this);



        Repeat.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View view) {
                Intent myIntent = new Intent(drinksActivity.this, drinksActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

                amountOfDrinks = Double.valueOf(inputAmountDrinks.getText().toString());
                amountInGrams = CalculateAmount();
                final double newAmount = amountInGrams + Double.valueOf(previousAmount);


                try {
                    FileOutputStream fos = openFileOutput("Alconsumed", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(newAmount)).getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent myIntent = new Intent(drinksActivity.this, timeActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

                amountOfDrinks = Double.valueOf(inputAmountDrinks.getText().toString());
                amountInGrams = CalculateAmount();
                final double newAmount = amountInGrams + Double.valueOf(previousAmount);

                try {
                    FileOutputStream fos = openFileOutput("Alconsumed", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(newAmount)).getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });




    }

/*
    public void repeat(View view) {
        Intent myIntent = new Intent(drinksActivity.this, drinksActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }
    public void continue_on(View view) {
        Intent myIntent = new Intent(drinksActivity.this, timeActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }*/

    private String openFile(String filename)
    {

        FileInputStream fis;
        try {
            fis = openFileInput(filename);

            byte[] input = new byte[fis.available()];
            while(fis.read(input) != -1)
            {
                value += new String(input);

            }

            fis.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i) {
            case 1 ://NIP
                ratio = .4;
                volume = 1.7;
                break; // optional

            case 2 ://Ale
                ratio = .085;
                volume = 16;
                break; // optional
            case 3 ://beer
                ratio = .05;
                volume = 12;
                break; // optional
            case 4 ://beer
                ratio = .05;
                volume = 16;
                break; // optional
            case 5 ://light beer
                ratio = .042;
                volume = 12;
                break; // optional
            case 6 ://light beer
                ratio = .042;
                volume = 16;
                break; // optional
            case 7 :
                ratio = .025;
                volume = 12;
                break; // optional

            case 8 :
                ratio = .6;
                volume = 2;
                break; // optional
            case 9 :
                ratio = .4;
                volume = 3.5;
                break; // optional

            case 10 :
                ratio = .44;
                volume = 1.5;
                break; // optional
            case 11 :
                ratio = .08;
                volume = 10;
                break; // optional

            case 12 :
                ratio = .075;
                volume = 12;
                break; // optional
            case 13 :
                ratio = .2768;
                volume = 4.75;
                break; // optional

            case 14 :
                ratio = .05;
                volume = 16;
                break; // optional
            case 15 :
                ratio = .40;
                volume = 1.5;
                break; // optional

            case 16 :
                ratio = .15;
                volume = 1.5;
                break; // optional
            case 17 :
                ratio = .075;
                volume = 16;
                break; // optional

            case 18 :
                ratio = .4;
                volume = 1.5;
                break; // optional
            case 19 :
                ratio = .4;
                volume = 1.5;
                break; // optional

            case 20 :
                ratio = .4;
                volume = 1.5;
                break; // optional
            case 21 :
                ratio = .12;
                volume = 2.5;
                break; // optional

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private double CalculateAmount()
    {
        double Amount = ratio*(23.333333)*volume*amountOfDrinks;
        return Amount;
    }
}