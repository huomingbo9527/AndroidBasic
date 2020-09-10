package com.huo.nest.button

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import com.huo.nest.utils.FRLog

class MyLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("MyLinearLayout  dispatchTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("MyLinearLayout  onInterceptTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.onInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("MyLinearLayout  onTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.onTouchEvent(event)
    }


}