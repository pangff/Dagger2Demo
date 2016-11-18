package com.pffair.dagger2demo;

import android.content.Context;

import dagger.Component;

/**
 * Created by pangff on 16/11/11.
 * Description BaseAComponent
 */
@BaseAScope
@Component(dependencies = ApplicationComponent.class,modules = BaseAModule.class)
public interface BaseAComponent {

    BaseActivity getBaseActivity();


    Context getAppContext();
}
