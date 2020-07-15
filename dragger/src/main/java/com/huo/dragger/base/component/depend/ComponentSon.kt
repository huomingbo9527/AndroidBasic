/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huo.dragger.base.component.depend

import dagger.Component
import javax.inject.Singleton

// Scope annotation that the AppComponent uses
// Classes annotated with @Singleton will have a unique instance in this Component
// Definition of a Dagger component that adds info from the different modules to the graph
//依赖在依赖会报错，不能多级依赖？
// com.huo.dragger.base.component.depend.ComponentMain depends on scoped components in a non-hierarchical scope ordering:
@Singleton
@Component(modules = [Module2::class])//,dependencies = [ComponentSonSon::class]
interface ComponentSon {
    fun getDependString2(): String
//    fun getComponentSonSon():ComponentSonSon
//    @Component.Builder
//    interface Builder {
//        fun appDependencies(appComponent: ComponentSonSon): Builder
//        fun build(): ComponentSon
//    }
}
