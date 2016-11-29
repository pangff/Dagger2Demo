package com.pffair.dagger2demo;

import android.app.Application;

/**
 * Created by pangff on 16/11/11.
 * Description MyApplication
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;

    public static MyApplication getInstance(){
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
}
