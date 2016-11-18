package com.pffair.dagger2demo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/11.
 * Description MainModule
 */

@Module
public class MainModule {

    @MobileScope
    @Provides
    public Mobile provideModule(String model){
        return new Mobile(model);
    }

    @Provides
    public String provideModel(){
        return "Google Nexus";
    }

//    @Provides
//    public Mobile provideModule(){
//        return new Mobile();
//    }
}
