package com.huo.nest.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 *
 */
class InterceptTrueEventViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    /***
     * ViewGroup::dispatchTouchEvent()  事件分发()
     * onInterceptTouchEvent()
     * (dispatchTransformedTouchEvent()) : child.dispatchTouchEvent()  or  (child == null)View.dispatchTouchEvent()
     * View::dispatchTouchEvent()  真正处理onTouchEvent()
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        return super.onInterceptTouchEvent(ev)
        return true
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
//        return super.onTouchEvent(ev)  //不处理 事件最终回到activity
//        return false   //不处理 事件最终回到activity
        return false   //处理  onInterceptTouchEvent拦截后   onInterceptTouchEvent方法不在执行
    }


}