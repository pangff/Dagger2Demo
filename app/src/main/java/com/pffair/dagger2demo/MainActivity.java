package com.pffair.dagger2demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    User mUser;

    @Inject
    Mobile mMobile;

    TextView mTextView;

    Button btBtn;

    @Inject
    Context context;

    @Inject
    BaseActivity mBaseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent.getInstance(this).inject(this);
        initView();
    }

    private void initView(){
        mTextView = (TextView) findViewById(R.id.tv_text);
        mTextView.setText(mUser.getName()+":"+mMobile.getModel()
                +"\nmMobile-hashcode:"+mMobile.hashCode()
                +"\nmMobile-hashcode:"+context.getPackageName());

        btBtn = (Button) findViewById(R.id.bt_btn);
        btBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
