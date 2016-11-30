package com.pffair.dagger2demo.user;

import com.pffair.dagger2demo.R;
import com.pffair.dagger2demo.base.BaseActivity;
import com.pffair.dagger2demo.base.BaseApplication;
import com.pffair.data.repository.datasource.entity.User;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pangff on 16/11/30.
 * Description UserActivity
 */

public class UserActivity extends BaseActivity implements UserContract.View {

    @BindView(R.id.tv_text)
    TextView mTextView;

    @Inject
    UserPresenter mUserPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        DaggerUserComponent.builder()
                .repositoryComponent(BaseApplication.getInstance().getRepositoryComponent())
                .userPresenterModule(new UserPresenterModule(this)).build()
                .inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mUserPresenter.start();
    }

    @Override
    public void showUsers(List<User> users) {
        String userStr = "";
        for(User user:users){
            userStr+=user.getName()+"\n";
        }
        mTextView.setText(userStr);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        Toast.makeText(UserActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UserContract.Presenter presenter) {

    }

    @OnClick(R.id.btn_remote_user)
    void loadRemoteUser(){
        mUserPresenter.loadUserRemote();
    }
}
