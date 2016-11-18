package com.pffair.dagger2demo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/11.
 * Description ApplicationModule
 */

@Module
public class ApplicationModule {

    Context mContext;

    public ApplicationModule(Context context){
        this.mContext = context;
    }

    @Singleton
    @Provides
    public Context provideAppContext(){
        return mContext;
    }
}
