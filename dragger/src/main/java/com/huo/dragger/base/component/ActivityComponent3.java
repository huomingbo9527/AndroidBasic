package com.huo.dragger.base.component;

import dagger.Component;
import dagger.Subcomponent;

@Component(dependencies = AppComponent.class)
interface ActivityComponent3 {
    void inject(ComponentStudyActivity activity);

//   //在module中指定subcomponents的Component必须显式地声明 Subcomponent.Builder
//    @Subcomponent.Builder
//    interface Builder {
//        ActivityComponent3 build();
//    }
}
