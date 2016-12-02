package com.pffair.dagger2demo;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by pangff on 16/11/28.
 * Description Role
 */
@Module
public class Role {

    String name;

    @Inject
    public Role(String name) {
        this.name = name;
    }

//    @Provides
    public String provideName() {
        return name;
    }

    public String getName() {
        return name;
    }
}
