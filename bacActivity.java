package com.example.kennethflores.ec_327_androidapp_updated;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class bacActivity extends AppCompatActivity {

    private TextView outputBAC;
    private TextView firstRange;
    private TextView amount;
    private TextView other;
    private Button helpButton;
    public static final DecimalFormat df1 = new DecimalFormat("#.###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        outputBAC = (TextView) findViewById(R.id.BAC);
        helpButton = (Button) findViewById(R.id.button9);
        helpButton.setVisibility(View.INVISIBLE);




        String alcamount = openfile("Alconsumed");
        String bodyweight = openfile("weight");
        String gender = openfile("Gender");
        String elapsedtime = openfile("Time");
        double BAC = Double.valueOf(alcamount) / (Double.valueOf(bodyweight) * Double.valueOf(gender));
        double realBAC = (BAC)*100 - (Double.valueOf(elapsedtime))*0.015;
        String finalBac = new Double(realBAC).toString();
        if(Double.valueOf(finalBac)<0) {
            finalBac = String.valueOf(0);
        }
        outputBAC.setText(df1.format(Double.valueOf(finalBac)));
        if(Double.valueOf(finalBac) >=.08){
            helpButton = (Button) findViewById(R.id.button9);
            helpButton.setVisibility(View.VISIBLE);
            helpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:6173534877"));
                    startActivity(i);

                }
            });


        }
        if(Double.valueOf(finalBac) < .03){
            firstRange = (TextView) findViewById(R.id.textView6);
            firstRange.setText("You are doing fine");
        }
        if(Double.valueOf(finalBac) >= .03  && Double.valueOf(finalBac) < .09){
            firstRange = (TextView) findViewById(R.id.textView6);
            firstRange.setText("Feeling of increased confidence, sense of daring. Look flushed or red in face. Trouble with fine actions, such writing.");
        }
        else if(Double.valueOf(finalBac) >=.08 && Double.valueOf((finalBac)) < .18){
            firstRange = (TextView) findViewById(R.id.textView6);
            firstRange.setText("Trouble seeing or focusing, slow reactions, sleepy, stumble often or lose balance easily.\n" +
                    "WARNING: You're exceeding the DUI legal limit.");
        }
        else if(Double.valueOf(finalBac) >= .18 && Double.valueOf(finalBac) <.25){
            firstRange = (TextView) findViewById(R.id.textView6);
            firstRange.setText("Confusion, dizziness, slurred speech and lack of muscle coordination.\n" +
                    "WARNING: You're exceeding the DUI legal limit.");
        }
        else if(Double.valueOf(finalBac) > .25){
            firstRange = (TextView) findViewById(R.id.textView6);
            firstRange.setText("Serious health issues, including death.\n" +
                    "WARNING: You're exceeding the DUI legal limit.");
        }




    }

    private String openfile(String filename)
    {
        String value = "";
        FileInputStream fis;
        try{

            fis = openFileInput(filename);

            byte[] input = new byte[fis.available()];
            while(fis.read(input) != -1)
            {
                value += new String(input);

            }
            fis.close();

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }

    public void onClick(View view) {
        Intent myIntent = new Intent(bacActivity.this, MainActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }

}