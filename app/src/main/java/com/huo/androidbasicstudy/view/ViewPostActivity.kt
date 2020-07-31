package com.huo.androidbasicstudy.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.LinearLayout
import com.huo.androidbasicstudy.R
import com.huo.androidbasicstudy.util.logV
import kotlinx.android.synthetic.main.activity_view_post.*

/**
 * 测试 view.post()
 */
class ViewPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_post)
        logV("ViewPost","开始执行${viewPostChild.measuredWidth}")
        viewPostParent.post {
            logV("ViewPost","我是viewPostParent de  Runnable${viewPostChild.measuredWidth}")
        }
        viewPostChild.post {
            logV("ViewPost","我是viewPostChild de  Runnable${viewPostChild.measuredWidth}")
        }
        logV("ViewPost","结束执行${viewPostChild.measuredWidth}")
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        logV("ViewPost","ViewPostActivity  onAttachedToWindow")
    }
}
class ViewPostChild @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        logV("ViewPost","ViewPostChild  onAttachedToWindow")
    }
}


class ViewPostParent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        logV("ViewPost","ViewPostParent  onAttachedToWindow")
    }
}