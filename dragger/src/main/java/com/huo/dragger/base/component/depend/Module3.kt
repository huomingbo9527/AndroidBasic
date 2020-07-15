package com.huo.dragger.base.component.depend

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module3 {
    @Singleton
    @Provides
    fun getDependArray():Array<String>{
        return arrayOf("String")
    }
}