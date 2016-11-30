package com.pffair.dagger2demo.base;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by pangff on 16/11/30.
 * Description ActivitytScoped
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivitytScoped {

}
