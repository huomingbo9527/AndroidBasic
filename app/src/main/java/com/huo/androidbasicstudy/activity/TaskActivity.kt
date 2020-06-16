package com.huo.androidbasicstudy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
    }
}