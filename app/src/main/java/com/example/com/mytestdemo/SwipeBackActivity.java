package com.example.com.mytestdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ant.liao.GifView;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.jude.swipbackhelper.SwipeListener;

/**
 * Created by MMC_mmc on 2015/12/10.
 */
public class SwipeBackActivity extends AppCompatActivity {
    private static int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        setTitle("activity_" + i);
        i++;
        setContentView(R.layout.activity_swipeback);
        initGif();

        Spinner spinner = (Spinner) findViewById(R.id.spinner_label);
        //使用数组作为数据源
        final String arr[] = new String[]{"周一", "周二", "周三", "周四", "周五", "周六",
                "周七"};
        // adpater对象
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        spinner.setAdapter(arrayAdapter);

        findViewById(R.id.my_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SwipeBackActivity.class));
            }
        });

        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(true)//设置是否可滑动
                .setSwipeEdge(200)//可滑动的范围。px。200表示为左边200px的屏幕
                .setSwipeEdgePercent(0.2f)//可滑动的范围。百分比。0.2表示为左边20%的屏幕
                .setSwipeSensitivity(0.5f)//对横向滑动手势的敏感程度。0为迟钝 1为敏感
                .setScrimColor(Color.WHITE)//底层阴影颜色
                .setClosePercent(0.8f)//触发关闭Activity百分比
                .setSwipeRelateEnable(false)//是否与下一级activity联动。默认是
                .setSwipeRelateOffset(500)//activity联动时的偏移量。默认500px。
                .addListener(new SwipeListener() {//滑动监听

                    @Override
                    public void onScroll(float percent, int px) {//滑动的百分比与距离
                    }

                    @Override
                    public void onEdgeTouch() {//当开始滑动
                    }

                    @Override
                    public void onScrollToClose() {//当滑动关闭
                    }
                });
    }

    private void initGif() {

        GifView gf1;
        // 从xml中得到GifView的句柄
        gf1 = (GifView) findViewById(R.id.imageView);
        // 设置Gif图片源
        gf1.setGifImage(R.drawable.fengshui);
        // 添加监听器
//        gf1.setOnClickListener(this);
        // 设置显示的大小，拉伸或者压缩
        gf1.setShowDimension(600, 250);
        // 设置加载方式：先加载后显示、边加载边显示、只显示第一帧再显示
        gf1.setGifImageType(GifView.GifImageType.COVER);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }
}
