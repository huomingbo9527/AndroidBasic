package com.ihealth.chronos.patient.base.base

import android.content.Context
import io.reactivex.Observable

interface IRepositoryManager<T> {

    /**
     * 获取 [Context]
     *
     * @return [Context]
     */
    val context: Context

    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service Retrofit service class
     * @param <T>     Retrofit service 类型
     * @return Retrofit service
    </T> */
    fun <T> obtainRetrofitService(service: Class<T>): Observable<T>?


    /**
     * 根据传入的 Class 获取对应的 RxCache service
     *
     * @param cache RxCache service class
     * @param <T>   RxCache service 类型
     * @return RxCache service
    </T> */
    fun <T> obtainCacheService(cache: Class<T>): T

    /**
     * 清理所有缓存
     */
    fun clearAllCache()
}