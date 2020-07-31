package com.huo.rxjava;

import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class ScheduleTest {

    //    2020-07-30 11:32:33.318 30851-30851/com.huo.androidbasicstudy I/System.out: Rxjava2UnitTest   testObserveOn  startThread[main,5,main]
//            2020-07-30 11:32:33.336 30851-30851/com.huo.androidbasicstudy I/System.out:  我是第一个map,我转化成字符串，我应该是 Schedulers.io() 执行线程? Thread[main,5,main]
//            2020-07-30 11:32:33.338 30851-30851/com.huo.androidbasicstudy I/System.out: Rxjava2UnitTest   testObserveOn  endThread[main,5,main]
//            2020-07-30 11:32:33.338 30851-30907/com.huo.androidbasicstudy I/System.out:  我是subscribe，我应该是 Schedulers.newThread() 执行线程?Thread[RxCachedThreadScheduler-1,5,main]
    public static Observable<Integer> getObservableJust() {
        return Observable.just(1);
    }

    public static Observable<Integer> getObservableCreate() {
        return Observable.create(emitter -> emitter.onNext(1));
    }


    /**
     * 2020-07-30 12:04:48.570 32538-32538/com.huo.androidbasicstudy I/System.out: ScheduleTest   testScheduleThread  startThread[main,5,main]
     * 2020-07-30 12:04:48.600 32538-32538/com.huo.androidbasicstudy I/System.out: ScheduleTest   testScheduleThread  endThread[main,5,main]
     * 2020-07-30 12:04:48.610 32538-32575/com.huo.androidbasicstudy I/System.out:  我是doOnSubscribe，执行线程?Thread[RxSingleScheduler-1,5,main]
     * 2020-07-30 12:04:48.612 32538-32575/com.huo.androidbasicstudy I/System.out:  我是第一个map，执行线程?Thread[RxSingleScheduler-1,5,main]
     * 2020-07-30 12:04:48.635 32538-32577/com.huo.androidbasicstudy I/System.out:  我是第二次map，执行线程?Thread[RxComputationThreadPool-1,5,main]
     * 2020-07-30 12:04:48.638 32538-32538/com.huo.androidbasicstudy I/System.out:  我是第三次map，执行线程?Thread[main,5,main]
     * 2020-07-30 12:04:48.640 32538-32538/com.huo.androidbasicstudy I/System.out:  我是subscribe，执行线程?Thread[main,5,main]
     *
     * 分析
     * subscribeOn订阅源的线程  subscribeOn可以设置多个,但是只有第一个生效，后面的都不会生效  doOnSubscribe操作符只在订阅线程内执行(生效的subscribeOn)
     * observeOn观察源的线程  observeOn可以多个，observeOn后面的操作符在该线程执行
     *
     */
    @SuppressLint("CheckResult")
    public static void testScheduleThread() {
        System.out.println("ScheduleTest   testScheduleThread  start" + Thread.currentThread());
        getObservableCreate()
                .map(integer -> {
                    String content = " 我是第一个map，执行线程?" + Thread.currentThread();
                    System.out.println(content);
                    return content;
                })
                .observeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .doOnSubscribe(center -> {
                    System.out.println(" 我是doOnSubscribe，执行线程?" + Thread.currentThread());
                })
                .observeOn(Schedulers.computation())
                .map(content -> {
                    Thread.sleep(3000);
                    System.out.println(" 我是第二次map，执行线程?" + Thread.currentThread());
                    return content;
                }).observeOn(AndroidSchedulers.mainThread())
                .map(content -> {
                    System.out.println(" 我是第三次map，执行线程?" + Thread.currentThread());
                    return content;
                })
                .subscribeOn(Schedulers.single())
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    s = " 我是subscribe，执行线程?" + Thread.currentThread();
                    System.out.println(s);
                });
        System.out.println("ScheduleTest   testScheduleThread  end" + Thread.currentThread());
    }
}
