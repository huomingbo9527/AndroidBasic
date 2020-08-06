package com.huo.androidbasicstudy.event

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.huo.androidbasicstudy.util.logV

/**

 */
class DispatchEventViewGroupParent @JvmOverloads constructor(
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
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onInterceptTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.onTouchEvent(ev)
    }

}