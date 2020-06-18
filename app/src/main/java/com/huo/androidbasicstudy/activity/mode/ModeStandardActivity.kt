package com.huo.androidbasicstudy.activity.mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R
import kotlinx.android.synthetic.main.activity_mode_standard2.*

class ModeStandardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_standard2)
        textView.setOnClickListener {
//            val intent = Intent(applicationContext, ModeSingleTaskActivity::class.java)
//            startActivity(intent)

            val intent = Intent(applicationContext, ModelSingleInstanceActivity::class.java)
            startActivity(intent)

//            val intent = Intent("com.huo.task.activity")
//            startActivity(intent)

        }

        taskId
    }
}