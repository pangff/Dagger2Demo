package com.pffair.dagger2demo.user;

import com.pffair.dagger2demo.base.BasePresenter;
import com.pffair.dagger2demo.base.BaseView;
import com.pffair.data.repository.datasource.entity.User;

import java.util.List;

/**
 * Created by pangff on 16/11/30.
 * Description UserContract
 */

public interface UserContract {

    interface View extends BaseView<Presenter> {

        void showUsers(List<User> users);

        void showErrorMsg(String errorMsg);
    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void loadUserRemote();

        public abstract void loadUserLocal();
    }
}
