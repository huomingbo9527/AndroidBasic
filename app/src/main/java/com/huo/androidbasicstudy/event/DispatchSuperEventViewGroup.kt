package com.huo.androidbasicstudy.event

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.huo.androidbasicstudy.util.logV

/**
 * 2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewGroup   stackTrace  dispatchTransformedTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewGroup   stackTrace  dispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewGroup   stackTrace  dispatchTransformedTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewGroup   stackTrace  dispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: com.android.internal.policy.DecorView   stackTrace  superDispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: com.android.internal.policy.PhoneWindow   stackTrace  superDispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.app.Activity   stackTrace  dispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: androidx.appcompat.view.WindowCallbackWrapper   stackTrace  dispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: com.android.internal.policy.DecorView   stackTrace  dispatchTouchEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.View   stackTrace  dispatchPointerEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$ViewPostImeInputStage   stackTrace  processPointerEvent
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$ViewPostImeInputStage   stackTrace  onProcess
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  deliver
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  onDeliverToNext
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  forward
2020-08-06 11:17:56.598 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$AsyncInputStage   stackTrace  forward
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  apply
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$AsyncInputStage   stackTrace  apply
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  deliver
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  onDeliverToNext
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  forward
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  apply
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$InputStage   stackTrace  deliver
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl   stackTrace  deliverInputEvent
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl   stackTrace  doProcessInputEvents
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl   stackTrace  enqueueInputEvent
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.ViewRootImpl$WindowInputEventReceiver   stackTrace  onInputEvent
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.view.InputEventReceiver   stackTrace  dispatchInputEvent
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.os.MessageQueue   stackTrace  nativePollOnce
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.os.MessageQueue   stackTrace  next
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.os.Looper   stackTrace  loop
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: android.app.ActivityThread   stackTrace  main
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: java.lang.reflect.Method   stackTrace  invoke
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: com.android.internal.os.Zygote$MethodAndArgsCaller   stackTrace  run
2020-08-06 11:17:56.599 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: com.android.internal.os.ZygoteInit   stackTrace  main
2020-08-06 11:17:56.600 25184-25184/com.huo.androidbasicstudy V/eventDispatchTest: DispatchTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent
 */
class DispatchSuperEventViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    /***
     * ViewGroup::dispatchTouchEvent()  事件分发()
     * onInterceptTouchEvent()
     * (dispatchTransformedTouchEvent()) : child.dispatchTouchEvent()  or  (child == null)View.dispatchTouchEvent()
     * View::dispatchTouchEvent()  真正处理onTouchEvent()
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}   dispatchTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        if(ev?.action == MotionEvent.ACTION_DOWN){
            parent.requestDisallowInterceptTouchEvent(true)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onInterceptTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return true
//        return super.onTouchEvent(ev)
    }

}