package com.huo.dragger.base.module;


import android.app.Activity;
import android.app.Application;

import com.huo.dragger.base.scope.ModuleBeanScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleStudyActivityModule {
    //-----------------------无参数方式-------------------------
    @ModuleBeanScope
    @Provides
    @Named("empty")//当有相同的返回值要给命名区分不同的返回值
    public ModuleBean getModuleBean(){
        return new ModuleBean();
    }


//-----------------------有参数方式-------------------------
    String name;
//    Activity activity;
//    public ModuleStudyActivityModule(String name,Activity activity) {
//        this.activity = activity;
//        this.name = name;
//    }

    public ModuleStudyActivityModule(String name) {
        this.name = name;
    }

    //getModuleBeanFromName方法用到了参数name  这里也要单独提供
    @Provides
    public String getName(){
        return name;
    }
    @Provides
    @ModuleBeanScope//作用域: 要在数据源、连接设置 保证接受到接受的数据都是一样的，原理在连接中采用doublchecheck生成同一个数据源
    public ModuleBean getModuleBeanFromName(String name){
        return new ModuleBean(name);
    }


//-----------------------有参数方式 Component.Builder模式-----
    //在android中activity application等都是系统创建的，他们作为参数的时候只能传进来
    //@Component.Builder模式实现参数传递
    @Provides
    public Application getActivityName(Activity activity){
        return activity.getApplication();
    }
//
//    @Provides
//    public Activity getActivity(){
//        return activity;
//    }
}
