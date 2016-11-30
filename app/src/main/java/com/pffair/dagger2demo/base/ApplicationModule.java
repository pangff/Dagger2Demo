package com.pffair.dagger2demo.base;

import android.content.Context;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/29.
 * Description ApplicationModule
 */

@Module
public class ApplicationModule {

    Context mContext;

    @Inject
    public ApplicationModule(Context context){
        this.mContext = context;
    }

    @Provides
    public Context provideContext(){
        return mContext;
    }
}
