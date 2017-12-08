package com.example.kennethflores.ec_327_androidapp_updated;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class yesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);
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
    }

    public void F(View view) {
        Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }

    public void M(View view){
        Intent myIntent = new Intent(yesActivity.this, weightActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);
    }
}
