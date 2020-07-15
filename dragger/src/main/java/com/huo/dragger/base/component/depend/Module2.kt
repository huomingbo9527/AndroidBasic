package com.huo.dragger.base.component.depend

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module2 {
    @Singleton
    @Provides
    fun getDependName():String{
        return "Depend   Module2"
    }
}