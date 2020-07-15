package com.huo.dragger.base.inject;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.huo.dragger.R;

import javax.inject.Inject;


public class DaggerInjectActivity extends AppCompatActivity {
    @Inject
    protected InjectTest test;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);
        View textMain = findViewById(R.id.textMain);
//        DaggerComponentTest.builder().build().inject(this);
//        DaggerMainDaggerActivityComponent.
//        DaggerActivity_MembersInjector m;
//         DaggerComponentTest.builder().build().inject(this);
        DaggerComponentTest.builder().build().inject(this);
        textMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.getContent();
            }
        });
    }


}
