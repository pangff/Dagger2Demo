package com.pffair.dagger2demo;

import dagger.Component;

/**
 * Created by pangff on 16/11/28.
 * Description MainComponent
 */
@Component(modules = {User.class,Role.class,StringModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
