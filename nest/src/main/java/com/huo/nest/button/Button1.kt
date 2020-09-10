package com.huo.nest.button

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button
import com.huo.nest.utils.FRLog

@SuppressLint("AppCompatCustomView")
class Button1 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    init {

    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("Button1  dispatchTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("Button1  onTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.onTouchEvent(event)
    }


}