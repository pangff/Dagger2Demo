package com.pffair.data.repository;


import com.pffair.data.repository.annotation.Local;
import com.pffair.data.repository.annotation.Remote;
import com.pffair.data.repository.datasource.UserDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pangff on 16/11/29.
 * Description UserRepository
 */
@Singleton
public class UserRepository implements UserDataSource {

    UserDataSource userRemoteDataSource;

    UserDataSource userLocalDataSource;

    boolean mCacheIsDirty = false;

    @Inject
    public UserRepository(@Remote UserDataSource userRemoteDataSource,
            @Local UserDataSource userLocalDataSource){
        this.userRemoteDataSource = userRemoteDataSource;
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void getUsers(LoadUsersCallback callback) {
        if(!mCacheIsDirty){
            userLocalDataSource.getUsers(callback);
        }else{
            userRemoteDataSource.getUsers(callback);
        }
    }

    @Override
    public void refreshUsers() {
        mCacheIsDirty = true;
    }
}
