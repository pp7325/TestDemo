package com.example.com.mytestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("jjj");
//        setSupportActionBar(toolbar);
    }

    public void timeGetter(View v) {
        startActivity(new Intent(this, TimeGetterActivity.class));
    }

    public void slideFinish(View v) {
        startActivity(new Intent(this, SwipeBackActivity.class));
    }

    public void meterial(View v) {
        startActivity(new Intent(this, MeterialActivity.class));
    }
}
