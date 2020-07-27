package com.huo.rxjava

import io.reactivex.Observable

//create、just、from、fromArray、fromIterable、Defer、Interval、Timer、Repeat等
object RxjavaCreate {
//    create：通过调用观察者的方法从头创建一个Observable
//    defer：在观察者订阅之前不创建这个Observable，为每一个观察者创建一个新的Observable
//    just：将对象或者对象集合转换成一个会发射这些对象的Observable
//    interval：创建一个定时发射事件的Observable
//    Timer：创建一个在指定延时之后发射数据的Observable


    fun create():Observable<String>{
        return Observable.create {
            it.onNext("123")
        }
    }

    fun just():Observable<String>{
        return Observable.just("123")
    }

}