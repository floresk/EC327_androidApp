package com.example.kennethflores.ec_327_androidapp_updated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;


public class appInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        TextView textview = (TextView)findViewById(R.id.textView5);
        textview.setMovementMethod(new ScrollingMovementMethod());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ScrollView scroller = new ScrollView(this);
        //scroller.addView(textview);
    }
    //android:theme="@style/AppTheme.NoActionBar"
}
