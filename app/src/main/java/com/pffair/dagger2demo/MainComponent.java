package com.pffair.dagger2demo;

import android.util.Log;

import dagger.Component;

/**
 * Created by pangff on 16/11/11.
 * Description MainComponent
 */

@MobileScope
@Component(dependencies = BaseAComponent.class, modules = MainModule.class)
public abstract class MainComponent {

    abstract void inject(MainActivity activity);

    abstract void inject(SecondActivity activity);

    public static MainComponent getInstance(BaseActivity activity) {
        Log.e("pangff","adsfa"+activity);
        return DaggerMainComponent.builder().baseAComponent(activity.getBaseAComponent()).mainModule(new MainModule())
                .build();
    }
}
