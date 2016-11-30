package com.pffair.dagger2demo.base;

import android.app.Application;

/**
 * Created by pangff on 16/11/11.
 * Description BaseApplication
 */

public class BaseApplication extends Application {

    RepositoryComponent mRepositoryComponent;

    private static BaseApplication application;

    public static BaseApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext())).build();
    }

    public RepositoryComponent getRepositoryComponent(){
        return mRepositoryComponent;
    }
}
