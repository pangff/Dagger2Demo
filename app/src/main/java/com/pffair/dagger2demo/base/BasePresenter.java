package com.pffair.dagger2demo.base;

import javax.inject.Inject;

public abstract class BasePresenter<T extends BaseView> {

    protected T mView;

    @Inject
    void bindPresenter(){
        mView.setPresenter(this);
    }

    public abstract void start();

}
