package com.huo.androidbasicstudy.activity.mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R
import kotlinx.android.synthetic.main.activity_mode_single_task.*

class ModeSingleTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_single_task)
        textView.setOnClickListener {

            val intent = Intent(applicationContext, ModeSingleAffinityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

//            val intent = Intent(applicationContext, ModeStandardActivity::class.java)
//            startActivity(intent)

//            val intent = Intent(applicationContext, ModeStandardActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP//清除其顶层的activity
//            startActivity(intent)

//            val intent = Intent(applicationContext, ModeStandardActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK //清空栈  放自己进去作为第一个
//            startActivity(intent)
        }
    }
}