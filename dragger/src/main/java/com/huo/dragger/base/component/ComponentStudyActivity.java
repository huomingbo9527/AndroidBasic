package com.huo.dragger.base.component;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.huo.dragger.R;


public class ComponentStudyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_component_study);
        View textMain = findViewById(R.id.textMain);

        //1,
        DaggerAppComponent.create().getActivityComponent().inject(this);
        //2,
        DaggerAppComponent.create().getActivityComponent2Builder().build().inject(this);
        //3,
        DaggerActivityComponent3.builder().appComponent(DaggerAppComponent.create()).build().inject(this);



        textMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showToast(getApplicationContext(),moduleBean.getContent());
            }
        });
    }


}
