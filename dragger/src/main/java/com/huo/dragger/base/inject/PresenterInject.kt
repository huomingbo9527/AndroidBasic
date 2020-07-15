package com.huo.dragger.base.inject

import javax.inject.Inject

/**
 * kotlin 构造函数加注解需要注意 多个构造函数的问题、构造函数带参数的问题
 * 多个构造函数，主构造函数加注解会报错，主构造函数会被所有辅助构造函数调用，dragger会报错
 */
open class PresenterInject @Inject constructor() {
    lateinit var sex:String
    lateinit var name:String

    //    constructor(name : String,sex :String) : this(name){
//        this.sex = sex
//    }

    fun getContent():String{
        return "PresenterInject  getContent()"
    }
}

data class People constructor(val name: String) {
//    @Inject
    constructor() : this("Tom")
}