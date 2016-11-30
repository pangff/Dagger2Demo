package com.pffair.data.repository.datasource.local;


import com.pffair.data.repository.datasource.UserDataSource;
import com.pffair.data.repository.datasource.entity.User;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by pangff on 16/11/29.
 * Description UserRemoteDataSource
 */
@Singleton
public class UserLocalDataSource implements UserDataSource {

    public UserLocalDataSource(Context context){

    }

    @Override
    public void getUsers(LoadUsersCallback callback) {
        List<User> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            User user = new User();
            user.setName("User-local:"+i);
            list.add(user);
        }
        callback.onUsersLoaded(list);
    }

    @Override
    public void refreshUsers() {

    }
}
