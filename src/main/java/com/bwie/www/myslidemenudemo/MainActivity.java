package com.bwie.www.myslidemenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化侧拉列表
        menu = new SlidingMenu(this);
        //让侧拉列表在左方
        menu.setMode(SlidingMenu.LEFT);
        //依附于activity
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        //设置全部activity都可以侧拉
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置除侧拉列表剩余的内容
        menu.setBehindWidth(400);
        //设置侧拉列表的渐变
        //menu.setFadeDegree(0f);
        //设置剩余内容的渐变
        menu.setOffsetFadeDegree(0.3f);
        View view = View.inflate(this, R.layout.slid_item, null);
        //把布局设置到侧拉列表中
        menu.setMenu(view);
        ImageView viewById = (ImageView) findViewById(R.id.title_img);
        //设置点击让侧拉列表开关
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                /*if (menu.isMenuShowing()){
                    menu.showContent();
                }else{
                    menu.showMenu();
                }*/
            }
        });
    }
}
