package com.example.com.mytestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Date date = new Date(1458040549348l);
        Log.i("aaa_", String.valueOf(new Date().getTime()));
        Log.i("aaa_", (date.getMonth()+1) + "," + date.getDate() + "," + date.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Log.i("aaa_", (cal.get(Calendar.MONTH)+1) + "," + cal.get(Calendar.DAY_OF_MONTH));

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

    public void actionbarOverlay(View v) {
        startActivity(new Intent(this, ActionbarOverlayActivity.class));
    }
}
