package com.huo.dragger.base.component;

import dagger.Component;

@Component(modules = {AppModule.class})
interface AppComponent {
    //1
    ActivityComponent1 getActivityComponent();
    //2
    ActivityComponent2.Builder getActivityComponent2Builder();

}
