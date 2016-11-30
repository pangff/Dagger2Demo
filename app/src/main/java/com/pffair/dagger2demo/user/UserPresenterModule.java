package com.pffair.dagger2demo.user;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/30.
 * Description UserPresenterModule
 */
@Module
public class UserPresenterModule {

    private final UserContract.View mView;

    public UserPresenterModule(UserContract.View view){
        mView = view;
    }

    @Provides
    public UserContract.View provideUserContractView(){
        return mView;
    }
}
