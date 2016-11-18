package com.pffair.dagger2demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by pangff on 16/11/11.
 * Description MobileScope
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileScope {

}
