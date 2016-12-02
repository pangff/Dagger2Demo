package com.pffair.dagger2demo;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainActivity extends BaseActivity {

    @Inject
    User mUser;


    @Inject
    Role mRole;

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject();
        initView();

    }

    private void inject(){
        MainActivity_MembersInjector.create(new Provider<User>() {
            @Override
            public User get() {
                return User_Factory.create().get();
            }
        }).injectMembers(this);
        DaggerMainComponent.builder().build().inject(this);
    }

    private void initView(){
        mTextView = (TextView) findViewById(R.id.tv_text);
        if(mUser!=null){
            mTextView.setText("用户："+mUser.getName());
        }
        if(mRole!=null){
            mTextView.setText(mTextView.getText()+"--角色:"+mRole.getName());
        }

    }
}
