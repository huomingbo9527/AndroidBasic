package com.huo.androidbasicstudy.activity.mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R
import kotlinx.android.synthetic.main.activity_mode_single_task.*

class ModeSingleAffinityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_single_affinity)
        textView.setOnClickListener {
            val intent = Intent(applicationContext, ModeStandardActivity::class.java)
            startActivity(intent)
        }
    }
}