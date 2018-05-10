package com.android.remote;

import android.app.Application;

/**
 * Created by wuxianke on 2018/4/10.
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
