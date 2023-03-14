package com.md.cfashsbugff;

import android.app.Application;
import android.content.Context;
import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;


public class MyApplication extends Application {
    private static Context mContext;//全局上下文对象
    public static Context applicationContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        applicationContext = this;

        Toast();

    }

    private void Toast() {
        ToastUtils defaultMaker = ToastUtils.getDefaultMaker();
        defaultMaker.setGravity(Gravity.CENTER, 0, 0);
    }

}
