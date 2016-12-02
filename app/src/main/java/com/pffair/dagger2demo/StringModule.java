package com.pffair.dagger2demo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/12/2.
 * Description StringModule
 */

@Module
public class StringModule {

    @Provides
    public String provideName(){
        return "哈哈哈";
    }

}
