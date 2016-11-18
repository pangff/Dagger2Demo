package com.pffair.dagger2demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * Created by pangff on 16/11/11.
 * Description SecondActivity
 */

public class SecondActivity extends BaseActivity {

    @Inject
    User mUser;

    @Inject
    Mobile mMobile;

    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainComponent.getInstance(this).inject(this);
        initView();
    }

    private void initView(){
        mTextView = (TextView) findViewById(R.id.tv_text);
        mTextView.setText(mUser.getName()+":"+mMobile.getModel());
        mTextView.setText(mUser.getName()+":"+mMobile.getModel()+"\nmMobile-hashcode:"+mMobile.hashCode());
    }
}
