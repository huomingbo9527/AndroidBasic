package com.huo.nest.button

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.huo.nest.utils.FRLog

class Button2 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatButton(context, attrs, defStyleAttr) {

    init {

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("Button2  dispatchTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("Button2  onTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.onTouchEvent(event)
    }


}