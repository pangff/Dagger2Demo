package com.pffair.dagger2demo;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by pangff on 16/11/11.
 * Description User
 */
@Module
public class User {

    private String name;

    @Inject
    public User(){
        this.name= "ABC";
    }

    public String getName(){
        return name;
    }

}
