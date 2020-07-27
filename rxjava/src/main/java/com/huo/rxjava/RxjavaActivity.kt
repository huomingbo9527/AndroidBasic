package com.huo.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//1、创建操作符
//举例：create、just、from、fromArray、fromIterable、Defer、Interval、Timer、Repeat等
//作用：可以快速的创建一个被观察者（Obserable）
//比较常用的有：
//create：通过调用观察者的方法从头创建一个Observable
//defer：在观察者订阅之前不创建这个Observable，为每一个观察者创建一个新的Observable
//just：将对象或者对象集合转换成一个会发射这些对象的Observable
//interval：创建一个定时发射事件的Observable
//Timer：创建一个在指定延时之后发射数据的Observable
//
//2、变换操作符
//举例：Map、Buffer、FlatMap等
//作用：可将Observable发送的数据进行变换
//Map：通过对序列的每一项都应用一个函数变换Observable发射的数据
//FlatMap：将observable发射的数据变换为observable集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable中，可以认为是将一个嵌套的数据结构展开的过程
//
//3、过滤操作符
//举例：debounce、throttleFirst、throttleLast、filter、skip、skipLast等
//作用：用来对Observable发射的数据进行选择，去除不需要的数据
//filter：过滤掉不符合条件的数据
//skip：跳过前多少项数据
//skipLast：跳过后多少项数据
//throttleFirst：取一段时间内发射的第一项数据，其他数据跳过（功能防抖）
//throttlelast：取一段时间内发射的最后一项数据，其他数据跳过
//debunce：只有一段时间后没有再次发射数据，才发射数据（搜索联系）
//
//4、组合操作符
//举例：merge、and、zip等
//作用：将多个Observable组合成一个单一的Observable
//merge：将两个Observable发射的数据合并成一个
//zip：将多个Observable发射的数据组合在一起
//
//5、错误处理
//举例：catch、retry
//catch：捕获，继续序列操作，将错误替换为正常的数据，从OnError通知中恢复
//retry：重试
//
//6、辅助操作符
//举例：observeOn、subscribleOn、subscribe、delay等
//observeOn：指定observe的调度线程
//subscribleOn：指定subscrible的调度线程
//subscribe：Observable用来订阅Observer，并触发事件发送
//delay：延迟一段时间发射结果数据
//
//7、算术和聚合操作
//举例：average、max、min、sum、reduce
//average：计算Observable发射的数据序列的平均值，然后发射这个结果
//max：计算并发射数据序列的最大值
//min：计算并发射序列的最小值
//sum：计算并发展数据序列的和
//reduce：按顺序对数据序列应用某个函数，然后返回这个值
//
//8、转换操作
//举例：to、blocking
//to：将Observable转换成其他类型的对象
//blocking：阻塞Observable的操作符
//
//RxJava的优点
//1、基于链式调用，让代码的逻辑变得清晰；
//2、能够方便的进行线程切换，轻松的完成异步操作；
//3、功能强大，提供了大量的操作符，方便开发者开发。
class RxjavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
    }



}