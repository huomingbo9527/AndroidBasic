package com.huo.dragger.base.component.depend

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module1 {
    @Singleton
    @Provides
    fun getDependName():ModuleBean{
        return ModuleBean("Depend   Module1")//"Depend   Module1"
    }
}