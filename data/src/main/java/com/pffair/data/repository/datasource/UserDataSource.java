package com.pffair.data.repository.datasource;

import com.pffair.data.repository.datasource.entity.User;

import java.util.List;

/**
 * Created by pangff on 16/11/29.
 * Description UserDataSource
 */

public interface UserDataSource {

    interface LoadUsersCallback {

        void onUsersLoaded(List<User> users);

        void onDataNotAvailable();
    }


   void getUsers(LoadUsersCallback callback);

    void refreshUsers();
}
