package com.pffair.dagger2demo;

import com.pffair.dagger2demo.base.BaseActivity;
import com.pffair.dagger2demo.book.BookActivity;
import com.pffair.dagger2demo.user.UserActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bt_btn_user)
    Button btBtnUser;

    @BindView(R.id.bt_btn_book)
    Button btBtnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btBtnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toUserActivity();
            }
        });

        btBtnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toBookActivity();
            }
        });
    }


    private void toUserActivity() {
        Intent intent = new Intent(MainActivity.this,UserActivity.class);
        startActivity(intent);
    }


    private void toBookActivity() {
        Intent intent = new Intent(MainActivity.this,BookActivity.class);
        startActivity(intent);
    }
}
