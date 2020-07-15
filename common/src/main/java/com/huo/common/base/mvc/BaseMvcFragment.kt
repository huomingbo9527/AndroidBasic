package com.ihealth.chronos.patient.base.base.mvc

import com.ihealth.chronos.patient.base.base.BaseFragment
import com.ihealth.chronos.patient.base.base.error.ApiException
import com.ihealth.chronos.patient.base.util.extension.logVerbose
import com.ihealth.chronos.patient.base.util.extension.onErrorHint
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMvcFragment: BaseFragment(){
    protected open var compositeDisposable = CompositeDisposable()
    override fun onDestroy() {
        super.onDestroy()
        //保证activity结束时取消所有正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }
    //rxjava2调用减少重复代码，subscribe要传递四个参数，这里做了error、pre、complete的默认实现
    //界面加载，success需要处理加载状态,
    //弹窗加载，success不需要处理加载状态，complete处理关闭弹窗
    /**
     * 默认异常处理，如果有需要自己处理
     */
    protected var onErrorPage = fun(it:Throwable){
        onErrorPage(it)
    }
    protected var onPrePage = fun(it: Disposable){
        onPrePage(it)
    }
    /**
     * 弹窗关闭弹框，在success,error,就不用处理
     */
    protected var onCompletePage = fun(){
        onCompletePage()
    }

    protected fun onPrePage(it: Disposable){
        logVerbose(" onPrePage   $it")
        showPageLoading()
    }

    protected open fun onErrorPage(it:Throwable){
        logVerbose(" onErrorPage   $it")
        it as ApiException
        completePageLoading(it.pageState)
    }

    protected fun onCompletePage(){
        logVerbose(" onCompletePage  ")
    }

    //-------------------下面是dialog的处理-----------

    /**
     * 默认异常处理，如果有需要自己处理
     */
    protected var onErrorDialog = fun(it:Throwable){
        onErrorDialog(it)
    }
    protected var onPreDialog = fun(it: Disposable){
        onPreDialog(it)
    }
    /**
     * 弹窗关闭弹框，success,就不用处理了
     */
    protected var onCompleteDialog = fun(){
        onCompleteDialog()
    }

    protected fun onPreDialog(it: Disposable){
        logVerbose(" onPreDialog   $it")
        showDialogLoading()
    }

    protected fun onErrorDialog(it:Throwable){
        logVerbose(" onErrorDialog   $it")
        onErrorHint(it as ApiException)
        dismissDialogLoading()
    }

    protected fun onCompleteDialog(){
        logVerbose(" onCompleteDialog  ")
        dismissDialogLoading()
    }



}