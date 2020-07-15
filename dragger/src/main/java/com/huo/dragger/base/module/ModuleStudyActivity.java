package com.huo.dragger.base.module;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.huo.dragger.R;
import com.huo.dragger.base.scope.ModuleBeanScope;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import static com.huo.dragger.DaggerUtilKt.showToast;


public class ModuleStudyActivity extends AppCompatActivity {
    @Named("empty")
    @Inject
    protected ModuleBean moduleBeanOther;
    @Named("empty")
    @ModuleBeanScope
    @Inject
    protected ModuleBean moduleBean;
    @ModuleBeanScope
    @Inject
    protected ModuleBean moduleBean2;

    @Inject
    protected Application activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_module_provider_study);
        View textMain = findViewById(R.id.textMain);
//        Dagger.builder().build().inject(this);
        //provider 方法无参数
//        DaggerModuleStudyActivityComponent.create().inject(this);
        //module  provider方法带参数的实现方式
//        DaggerModuleStudyActivityComponent.builder()
//                .moduleStudyActivityModule(new ModuleStudyActivityModule("大圣",this))
//                .build()
//                .inject(this);
//        DaggerModuleStudyActivityComponent.builder().set(this).buildSelf().inject(this);
        DaggerModuleStudyActivityComponent.builder()
                .setActivity(this)
                .setModule(new ModuleStudyActivityModule("大圣"))
                .buildSelf()
                .inject(this);
        textMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showToast(getApplicationContext(),moduleBean.getContent());
                Log.e("ModuleStudyActivity","moduleBeanOther  = "+moduleBeanOther.toString());
                Log.e("ModuleStudyActivity","moduleBean  = "+moduleBean.toString());
                Log.e("ModuleStudyActivity","moduleBean2  = "+moduleBean2.toString());
                Log.e("ModuleStudyActivity","activityName  = "+activity);
            }
        });
    }


}
