package com.example.kennethflores.ec_327_androidapp_updated;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class yesActivity extends AppCompatActivity {

    Button MaleButton;
    Button FemaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MaleButton = (Button)findViewById(R.id.button3);
        FemaleButton = (Button)findViewById(R.id.button5);

        MaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);


                try {
                    FileOutputStream fos = openFileOutput("Alconsumed", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(0)).getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                try {
                    FileOutputStream fos = openFileOutput("Gender", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(.68)).getBytes());
                    fos.close();
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        FemaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

                try {
                    FileOutputStream fos = openFileOutput("Alconsumed", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(0)).getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                try {
                    FileOutputStream fos = openFileOutput("Gender", Context.MODE_PRIVATE);
                    fos.write((String.valueOf(.55)).getBytes());
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


/*
    public void F(View view) {
        Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }

    public void M(View view){
        Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }*/
}
