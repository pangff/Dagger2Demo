package com.pffair.dagger2demo;

import javax.inject.Inject;

/**
 * Created by pangff on 16/11/11.
 * Description User
 */

public class User {

    private String name;

    @Inject
    public User(){
        this.name= "哈哈哈";
    }

    public String getName(){
        return name;
    }

}
