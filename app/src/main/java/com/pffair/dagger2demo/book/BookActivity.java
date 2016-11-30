package com.pffair.dagger2demo.book;

import com.pffair.dagger2demo.R;
import com.pffair.dagger2demo.base.BaseActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by pangff on 16/11/30.
 * Description BookActivity
 */

public class BookActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }
}
