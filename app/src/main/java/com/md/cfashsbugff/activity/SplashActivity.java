package com.md.cfashsbugff.activity;

import android.os.Handler;

import com.blankj.utilcode.util.SPUtils;
import com.md.cfashsbugff.MainActivity;
import com.md.cfashsbugff.R;
import com.md.cfashsbugff.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        NoStatusBar();
    }

    @Override
    public void iniData() {
//设置等待时间，单位为毫秒
        final int time = 2000;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SPUtils.getInstance().getString("first").isEmpty()) {
                    openActivity(AgreeActivity.class);
                } else {
                    openActivity(MainActivity.class);
                }
                finish();


            }
        }, time);
    }

    @Override
    public void initListen() {

    }
}