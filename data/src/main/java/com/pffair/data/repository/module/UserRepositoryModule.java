package com.pffair.data.repository.module;


import com.pffair.data.repository.annotation.Local;
import com.pffair.data.repository.annotation.Remote;
import com.pffair.data.repository.datasource.UserDataSource;
import com.pffair.data.repository.datasource.local.UserLocalDataSource;
import com.pffair.data.repository.datasource.remote.UserRemoteDataSource;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/29.
 * Description UserRepositoryModule
 */
@Module
public class UserRepositoryModule{

    @Singleton
    @Provides
    @Local
    UserDataSource provideUserLocalDataSource(Context context) {
        return new UserLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    UserDataSource provideUserRemoteDataSource() {
        return new UserRemoteDataSource();
    }
}
