package com.huo.androidbasicstudy.event

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.huo.androidbasicstudy.R
import com.huo.androidbasicstudy.util.logV
import kotlinx.android.synthetic.main.activity_event.*

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
class EventActivity : AppCompatActivity() {
    companion object{
        const val eventDispatchTextTag = "eventDispatchTest"
        fun getExecutingMethodName():String {
            val stackTrace = Thread.currentThread().stackTrace;
//            stackTrace.forEach {//打印当前调用栈
//                logV(EventActivity.eventDispatchTextTag,"${it.className}   stackTrace  ${it.methodName}")
//            }
            val e = stackTrace[3]
            return e.methodName;
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val displayMetrics = resources.displayMetrics
        val density = displayMetrics.density
        val withChild = displayMetrics.widthPixels
        val heightChild = displayMetrics.heightPixels /8

        /**
         *  dispatchTouchEvent 返回true   不执行该ViewGroup的onInterceptTouchEvent、onTouchEvent，子view当然也获取不到事件，外部view如果不拦截的话，调用流程activity -> parent -> 该view的dispatchTouchEvent
        2020-08-06 13:01:25.523 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:01:25.525 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:01:25.525 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 13:01:25.526 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:01:25.546 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.547 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.548 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     2
        2020-08-06 13:01:25.549 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.600 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.601 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.602 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     2
        2020-08-06 13:01:25.602 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:01:25.604 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 13:01:25.604 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 13:01:25.605 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     1
        2020-08-06 13:01:25.606 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     1
         */
        val dispatchTrueEventViewGroup = DispatchTrueEventViewGroup(this)
        dispatchTrueEventViewGroup.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorAccent))
        dispatchTrueEventViewGroup.addView(DispatchTrueEventView(this),withChild,heightChild)
        val dispatchEventViewGroupTrueBody = DispatchEventViewGroupParent(this)
        dispatchEventViewGroupTrueBody.addView(dispatchTrueEventViewGroup,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroupTrueBody,withChild,heightChild)

        /**
         * dispatchTouchEvent 返回false  不执行该ViewGroup的onInterceptTouchEvent、onTouchEvent，子view当然也获取不到事件  事件返回:外层view回调onTouchEvent,如果都不处理最终由activity onTouchEvent事件处理
         * 执行activity  onTouchEvent dispatchTouchEvent onTouchEvent ...  事件都没有处理最终要activity来处理事件
        2020-08-06 13:04:46.280 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:04:46.281 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:04:46.282 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 13:04:46.282 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchFalseEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 13:04:46.283 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onTouchEvent  onTouchEvent     0
        2020-08-06 13:04:46.285 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     0
        2020-08-06 13:04:46.325 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:04:46.327 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     2
        2020-08-06 13:04:46.458 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:04:46.458 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     2
        2020-08-06 13:04:46.461 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 13:04:46.461 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     2
        2020-08-06 13:04:46.462 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 13:04:46.463 29142-29142/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     1
         */
        val dispatchFalseEventViewGroup = DispatchFalseEventViewGroup(this)
        dispatchFalseEventViewGroup.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorPrimary))
        dispatchFalseEventViewGroup.addView(DispatchTrueEventView(this),withChild,heightChild)
        val dispatchEventViewGroup = DispatchEventViewGroupParent(this)
        dispatchEventViewGroup.addView(dispatchFalseEventViewGroup,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroup,withChild,heightChild)

        /**
         * dispatchTouchEvent
         * 1,该view返回super,子view返回true,同该view返回true是一样的，
         * 2,该view返回super,子view返回false和该view返回的false是一个效果，
         * 3,该view返回super,子view返回super的话，默认是返回activity处理onTouch事件
         */
        val dispatchSuperEventViewGroup = DispatchSuperEventViewGroup(this)
        dispatchSuperEventViewGroup.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorPrimaryDark))
        dispatchSuperEventViewGroup.addView(DispatchTrueEventView(this),withChild,heightChild)
        val dispatchEventViewGroupParent = DispatchEventViewGroupParent(this)
        dispatchEventViewGroupParent.addView(dispatchSuperEventViewGroup,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroupParent,withChild,heightChild)

        /**
         * dispatchTouchEvent 没有View,嵌套全是ViewGroup
         * ViewGroup 没有响应触摸事件  最后事件回传递到activity,以后都会传递到activity处理
         */
        val dispatchSuperEventViewGroupNoChild = DispatchSuperEventViewGroup(this)
        dispatchSuperEventViewGroupNoChild.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorAccent))
        val dispatchEventViewGroupParentNoChild = DispatchEventViewGroupParent(this)
        dispatchEventViewGroupParentNoChild.addView(dispatchSuperEventViewGroupNoChild,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroupParentNoChild,withChild,heightChild)

        /**
         * onInterceptTouchEvent
         * 返回true    onTouchEvent()返回super false  事件不处理 最终activity处理事件
         *
        2020-08-06 14:31:23.922 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 14:31:23.923 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 14:31:23.924 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 14:31:23.924 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 14:31:23.926 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onTouchEvent  onTouchEvent     0
        2020-08-06 14:31:23.927 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onTouchEvent  onTouchEvent     0
        2020-08-06 14:31:23.930 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     0
        2020-08-06 14:31:23.943 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 14:31:24.010 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     2
        2020-08-06 14:31:24.021 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 14:31:24.021 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     2
        2020-08-06 14:31:24.022 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 14:31:24.022 32089-32089/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  onTouchEvent     1

         *  返回true    onTouchEvent()返回true    onInterceptTouchEvent不在执行
        2020-08-06 14:36:29.567 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 14:36:29.568 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 14:36:29.570 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 14:36:29.571 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 14:36:29.571 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 14:36:29.572 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onTouchEvent  onTouchEvent     0
        2020-08-06 14:36:29.584 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 14:36:29.585 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 14:36:29.585 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     2
        2020-08-06 14:36:29.586 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 14:36:29.586 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onTouchEvent  onTouchEvent     2
        2020-08-06 14:36:29.711 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 14:36:29.713 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 14:36:29.715 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     1
        2020-08-06 14:36:29.717 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 14:36:29.719 32420-32420/com.huo.androidbasicstudy V/eventDispatchTest: InterceptTrueEventViewGroup  onTouchEvent  onTouchEvent     1
         */
        val interceptTrueEventViewGroup = InterceptTrueEventViewGroup(this)
        interceptTrueEventViewGroup.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorPrimaryDark))
        interceptTrueEventViewGroup.addView(DispatchTrueEventView(this),withChild,heightChild)
        val dispatchEventViewGroupParentInter = DispatchEventViewGroupParent(this)
        dispatchEventViewGroupParentInter.addView(interceptTrueEventViewGroup,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroupParentInter,withChild,heightChild)


        /**
         * onTouch
         * 返回true, 消费事件
         *
         * 2020-08-06 15:09:06.487 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 15:09:06.489 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 15:09:06.490 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 15:09:06.491 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 15:09:06.491 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup  onInterceptTouchEvent  onInterceptTouchEvent     0
        2020-08-06 15:09:06.492 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView   dispatchTouchEvent  dispatchTouchEvent     0
        2020-08-06 15:09:06.493 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView  onTouchEvent  onTouchEvent     0
        2020-08-06 15:09:06.518 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 15:09:06.519 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 15:09:06.520 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     2
        2020-08-06 15:09:06.520 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 15:09:06.521 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup  onInterceptTouchEvent  onInterceptTouchEvent     2
        2020-08-06 15:09:06.522 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView   dispatchTouchEvent  dispatchTouchEvent     2
        2020-08-06 15:09:06.522 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView  onTouchEvent  onTouchEvent     2
        2020-08-06 15:09:07.182 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: EventActivity   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 15:09:07.183 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 15:09:07.183 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: DispatchEventViewGroupParent  onInterceptTouchEvent  onInterceptTouchEvent     1
        2020-08-06 15:09:07.184 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 15:09:07.184 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: InterceptFalseEventViewGroup  onInterceptTouchEvent  onInterceptTouchEvent     1
        2020-08-06 15:09:07.185 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView   dispatchTouchEvent  dispatchTouchEvent     1
        2020-08-06 15:09:07.185 2084-2084/com.huo.androidbasicstudy V/eventDispatchTest: TouchTrueEventView  onTouchEvent  onTouchEvent     1
         */
        val interceptFalseEventViewGroup = InterceptFalseEventViewGroup(this)
        interceptFalseEventViewGroup.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.colorAccent))
        interceptFalseEventViewGroup.addView(TouchTrueEventView(this),withChild,heightChild)
        val dispatchEventViewGroupParentInterFalse = DispatchEventViewGroupParent(this)
        dispatchEventViewGroupParentInterFalse.addView(interceptFalseEventViewGroup,withChild,heightChild)
        eventBaseBody.addView(dispatchEventViewGroupParentInterFalse,withChild,heightChild)


    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}   dispatchTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}   dispatchTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.onTouchEvent(ev)
    }


}