package com.pffair.dagger2demo;

import javax.inject.Inject;

/**
 * Created by pangff on 16/11/11.
 * Description Mobile
 */

public class Mobile {

    private String model;

    @Inject
    public Mobile(){
        this.model = "Nexus";
    }

    public Mobile(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }
}
