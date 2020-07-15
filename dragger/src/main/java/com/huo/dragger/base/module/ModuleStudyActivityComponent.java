package com.huo.dragger.base.module;


import android.app.Activity;

import com.huo.dragger.base.scope.ModuleBeanScope;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@ModuleBeanScope
@Component(modules = ModuleStudyActivityModule.class)
public interface ModuleStudyActivityComponent {
    void inject(ModuleStudyActivity receiver);

    @Component.Builder//Builder方式传递参数
    interface ActivityNameBuilder{
        //创建Component的时候绑定实例
        @BindsInstance
        ActivityNameBuilder setActivity(Activity simpleActivity);
        //使用了Builder就需要显式的指定带参数的module作为builder的参数
        ActivityNameBuilder setModule(ModuleStudyActivityModule simpleModule);
        ModuleStudyActivityComponent buildSelf();
    }
}
