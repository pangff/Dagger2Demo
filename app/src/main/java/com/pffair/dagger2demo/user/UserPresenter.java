package com.pffair.dagger2demo.user;

import com.pffair.data.repository.UserRepository;
import com.pffair.data.repository.datasource.UserDataSource;
import com.pffair.data.repository.datasource.entity.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pangff on 16/11/30.
 * Description UserPresenter
 */

public class UserPresenter extends UserContract.Presenter {

    UserRepository mUserRepository;

    @Inject
    public UserPresenter(UserRepository userRepository,UserContract.View view){
        this.mUserRepository = userRepository;
        this.mView = view;
    }

    @Override
    public void start() {
        loadUserLocal();
    }

    @Override
    public void loadUserRemote() {
        mUserRepository.refreshUsers();
        mUserRepository.getUsers(new UserDataSource.LoadUsersCallback() {
            @Override
            public void onUsersLoaded(List<User> users) {
                mView.showUsers(users);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showErrorMsg("数据加载失败");
            }
        });
    }

    @Override
    public void loadUserLocal() {
        mUserRepository.getUsers(new UserDataSource.LoadUsersCallback() {
            @Override
            public void onUsersLoaded(List<User> users) {
                mView.showUsers(users);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showErrorMsg("数据加载失败");
            }
        });
    }
}
