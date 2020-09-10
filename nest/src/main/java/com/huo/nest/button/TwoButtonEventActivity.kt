package com.huo.nest.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.huo.nest.R
import com.huo.nest.utils.FRLog

/**
 * 测试两个button 点击一个button滑动到第二个button 事件机制
 */
class TwoButtonEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_button_event)
        findViewById<View>(R.id.text2).setOnClickListener {

        }
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("TwoButtonEventActivity  dispatchTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.dispatchTouchEvent(event)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        FRLog.d("TwoButtonEventActivity  onTouchEvent:  x = ${event?.x}    y = ${event?.y}   type = ${event?.action}")
        return super.onTouchEvent(event)
    }

    fun onClick1(view: View) {}
}