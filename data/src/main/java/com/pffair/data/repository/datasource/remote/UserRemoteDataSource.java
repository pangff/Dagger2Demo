package com.pffair.data.repository.datasource.remote;


import com.pffair.data.repository.datasource.UserDataSource;
import com.pffair.data.repository.datasource.entity.User;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by pangff on 16/11/29.
 * Description UserRemoteDataSource
 */
@Singleton
public class UserRemoteDataSource implements UserDataSource {

    @Override
    public void getUsers(final LoadUsersCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<User> list = new ArrayList<>();
                for(int i=0;i<30;i++){
                    User user = new User();
                    user.setName("User-remote:"+i);
                    list.add(user);
                }
                callback.onUsersLoaded(list);
            }
        }, 1000);
    }

    @Override
    public void refreshUsers() {

    }
}
