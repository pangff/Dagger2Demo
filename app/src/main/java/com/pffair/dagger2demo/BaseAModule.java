package com.pffair.dagger2demo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/11.
 * Description BaseAModule
 */

@Module
public class BaseAModule {

    BaseActivity mBaseActivity;

    @BaseAScope
    public BaseAModule(BaseActivity activity){
        this.mBaseActivity = activity;
    }

    @Provides
    public BaseActivity provideBaseActivity(){
        return mBaseActivity;
    }
}
