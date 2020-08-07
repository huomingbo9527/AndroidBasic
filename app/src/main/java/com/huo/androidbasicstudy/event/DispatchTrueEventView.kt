package com.huo.androidbasicstudy.event

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.huo.androidbasicstudy.util.logV

class DispatchTrueEventView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = TextPaint()
    var content: String = ""
    /***
     * ViewGroup::dispatchTouchEvent()  事件分发()
     * onInterceptTouchEvent()
     * (dispatchTransformedTouchEvent()) : child.dispatchTouchEvent()  or  (child == null)View.dispatchTouchEvent()
     * View::dispatchTouchEvent()  真正处理onTouchEvent()
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}   dispatchTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.dispatchTouchEvent(ev)
//        return true
    }
//
//    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onInterceptTouchEvent  ${EventActivity.getExecutingMethodName()}")
//        return super.onInterceptTouchEvent(ev)
//    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        logV(EventActivity.eventDispatchTextTag,"${this.javaClass.simpleName}  onTouchEvent  ${EventActivity.getExecutingMethodName()}     ${ev?.action}")
        return super.onTouchEvent(ev)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.textSize = 30f
//        canvas?.drawText(content,50f,50f,paint)
        val myStaticLayout = StaticLayout(
            content,
            paint,
            canvas!!.width,
            Layout.Alignment.ALIGN_NORMAL,
            1.0f,
            0.0f,
            false
        )
        myStaticLayout.draw(canvas)
    }

    fun setShowContent(content:String) : DispatchTrueEventView{
        this.content = content
        invalidate()
        return this@DispatchTrueEventView
    }


}