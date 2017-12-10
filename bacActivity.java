package com.example.kennethflores.ec_327_androidapp_updated;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class bacActivity extends AppCompatActivity {

    private TextView outputBAC;
    private TextView amount;
    private TextView other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        outputBAC = (TextView) findViewById(R.id.BAC);




        String alcamount = openfile("Alconsumed");
        String bodyweight = openfile("weight");
        String gender = openfile("Gender");
        String elapsedtime = openfile("Time");
        double BAC = Double.valueOf(alcamount) / (Double.valueOf(bodyweight) * Double.valueOf(gender));
        double realBAC = (BAC)*100 - (Double.valueOf(elapsedtime))*0.015;
        String finalBac = new Double(realBAC).toString();
        outputBAC.setText(finalBac);




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
