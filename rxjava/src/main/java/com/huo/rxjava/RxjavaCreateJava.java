package com.huo.rxjava;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.observers.DisposableObserver;

//create、just、from、fromArray、fromIterable、Defer、Interval、Timer、Repeat等
class RxjavaCreateJava {
    public static final String TAG = "RxjavaCreateJava";
//    create：通过调用观察者的方法从头创建一个Observable
//    defer：在观察者订阅之前不创建这个Observable，为每一个观察者创建一个新的Observable
//    just：将对象或者对象集合转换成一个会发射这些对象的Observable
//    interval：创建一个定时发射事件的Observable
//    Timer：创建一个在指定延时之后发射数据的Observable
    public static Observable<String> create(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("123");
            }
        });
    }

    public static Observable<String> defer(){
        return Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return Observable.just("123");
            }
        });
    }

    @SuppressLint("CheckResult")
    public static Observable<Long> interval(){
//        return Observable.interval(0, 5, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(getObserver(1));

        return Observable.interval(1,1, TimeUnit.SECONDS);
    }

    public static Observable<Long> Timer(){
//        Observable.interval(1,1, TimeUnit.SECONDS);
        return Observable.timer(1, TimeUnit.SECONDS);
    }


    private static DisposableObserver getObserver(final int id) {
        DisposableObserver disposableObserver = new DisposableObserver<Object>() {
            @Override
            public void onNext(Object o) {
                Log.d(id + TAG, "#####开始#####");
                Log.d(id + "数据", String.valueOf(o));
                Log.d(id + TAG, "#####结束#####");
            }

            @Override
            public void onComplete() {
                Log.d(id + TAG, "onComplete");
            }
            @Override
            public void onError(Throwable e) {
                Log.e(id + TAG, e.toString(), e);
            }
        };
        return disposableObserver;
    }
}
