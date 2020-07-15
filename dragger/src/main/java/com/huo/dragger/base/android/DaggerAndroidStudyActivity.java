package com.huo.dragger.base.android;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huo.dragger.R;


public class DaggerAndroidStudyActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_component_study);
        View textMain = findViewById(R.id.textMain);

        textMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showToast(getApplicationContext(),moduleBean.getContent());
            }
        });
    }


}
