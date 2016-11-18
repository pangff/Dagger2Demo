package com.pffair.dagger2demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pangff on 16/11/11.
 * Description BaseActivity
 */

public class BaseActivity extends AppCompatActivity {

    BaseAComponent mBaseAComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseAComponent = DaggerBaseAComponent.builder()
                .applicationComponent(MyApplication.getInstance().getApplicationComponent())
                .baseAModule(new BaseAModule(this)).build();
    }

    public BaseAComponent getBaseAComponent() {
        return mBaseAComponent;
    }

}
