package com.pffair.dagger2demo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pangff on 16/11/11.
 * Description ApplicationComponent
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context getAppContext();
}
