package com.pffair.dagger2demo.user;

import com.pffair.dagger2demo.base.ActivitytScoped;
import com.pffair.dagger2demo.base.RepositoryComponent;

import dagger.Component;

/**
 * Created by pangff on 16/11/30.
 * Description UserComponent
 */
@ActivitytScoped
@Component(dependencies = RepositoryComponent.class,modules = {UserPresenterModule.class})
public interface UserComponent {

     void inject(UserActivity userActivity);
}
