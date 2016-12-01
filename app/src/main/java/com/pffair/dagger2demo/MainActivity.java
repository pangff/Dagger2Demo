package com.pffair.dagger2demo;

import com.pffair.dagger2demo.annotation.AnnotationTargetBean;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    TextView mTextView;

    Button btBtn;

    AnnotationTargetBean mAnnotationTragetBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAnnotationTragetBean = new AnnotationTargetBean();
//       DaggerMainComponent.builder().build().inject(this);

//        MainActivity_MembersInjector.create(new Provider<User>() {
//            @Override
//            public User get() {
//                return User_Factory.create().get();
//            }
//        }, new Provider<Role>() {
//            @Override
//            public Role get() {
//                return Role_Factory.create(new Provider<String>() {
//                    @Override
//                    public String get() {
//                        return "是Android开发";
//                    }
//                }).get();
//            }
//        }).injectMembers(this);

//        DaggerMainComponent.builder().role(new Role("是Android开发")).build().inject(this);
        initView();

    }

    private void initView(){
        mTextView = (TextView) findViewById(R.id.tv_text);
//        mTextView.setText(mUser.getName()+mRole.getName());
        btBtn = (Button) findViewById(R.id.bt_btn);
        btBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
