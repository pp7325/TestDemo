package com.example.com.mytestdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by MMC_mmc on 2015/11/30.
 */
public class TimeGetterActivity extends Activity {

    TextView tvResult;
    TextView methed;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_getter);
        tvResult = (TextView) findViewById(R.id.tv_result);
        etInput = (EditText) findViewById(R.id.et_input);
        methed = (TextView) findViewById(R.id.methed);
    }

    public void system(View v) {
        tvResult.setText(System.currentTimeMillis() + "");
        methed.setText("tvResult.setText(System.currentTimeMillis() + \"\");");
    }

    public void sdFomart(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date etDate = null;
        try {
            etDate = sdf.parse(etInput.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (etDate == null) {
            tvResult.setText(new Date().getTime() + "");
            Toast.makeText(this, "date格式错误,显示当前时间", Toast.LENGTH_SHORT).show();
        } else
            tvResult.setText(etDate.getTime() + "");
        methed.setText("        SimpleDateFormat sdf = new SimpleDateFormat(\"yyyy-MM-dd\");\n" +
                        "        Date etDate = null;\n" +
                        "        try {\n" +
                        "            etDate = sdf.parse(etInput.getText().toString());\n" +
                        "        } catch (ParseException e) {\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "       tvResult.setText(new Date().getTime() + \"\");"
        );
    }

    public void on2(View v) {

        //获取时区
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
//        tvResult.setText(timeZone.getDisplayName() + "," + timeZone.getID());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
        Date etDate = null;
        Date etDate2 = null;
        try {
            etDate = sdf.parse("2015-1-1");
            etDate2 = sdf2.parse("2015-1-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvResult.setText(etDate.getTime() + "," + etDate2.getTime());

        methed.setText("SimpleDateFormat sdf = new SimpleDateFormat(\"yyyy-MM-dd\");\n" +
                "SimpleDateFormat sdf2 = new SimpleDateFormat(\"yyyy-MM-dd\");\n" +
                "sdf2.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));\n" +
                "Date etDate = null;\n" +
                "Date etDate2 = null;\n" +
                "try {\n" +
                "   etDate = sdf.parse(\"2015-1-1\");\n" +
                "   etDate2 = sdf2.parse(\"2015-1-1\");\n" +
                "} catch (ParseException e) {\n" +
                "   e.printStackTrace();\n" +
                "}\n" +
                "tvResult.setText(etDate.getTime() + \",\" + etDate2.getTime());");
    }

    public void on1(View v) {
        TimeZone tz = TimeZone.getDefault();
        String s = tz.getDisplayName() + "  " + tz.getID();
        tvResult.setText(s);
        methed.setText("TimeZone tz = TimeZone.getDefault();\n" +
                "String s =tz.getDisplayName() + \"  \" + tz.getID();\n" +
                "tvResult.setText(s);");
    }
}
