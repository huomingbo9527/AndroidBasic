package com.huo.dragger.base.component;

import dagger.Subcomponent;

@Subcomponent
interface ActivityComponent2 {
    void inject(ComponentStudyActivity activity);

   //在module中指定subcomponents的Component必须显式地声明 Subcomponent.Builder
    @Subcomponent.Builder
    interface Builder {
        ActivityComponent2 build();
    }
}
