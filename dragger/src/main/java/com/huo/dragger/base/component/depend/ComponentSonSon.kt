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
//@Singleton 不能依赖其他的作用域，理解为大的作用域不能依赖低级的作用域，只能依赖更高级的作用域
@Singleton
@Component(modules = [Module3::class])
interface ComponentSonSon {
//    fun getDependInt(): Int
    fun getDependArray():Array<String>//被依赖要提供获取数据的方法  否则报错
}
