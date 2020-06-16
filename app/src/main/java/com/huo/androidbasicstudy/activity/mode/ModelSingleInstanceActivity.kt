package com.huo.androidbasicstudy.activity.mode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R
import kotlinx.android.synthetic.main.activity_model_single_instance.*

class ModelSingleInstanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_single_instance)
        textView.setOnClickListener {
            startActivity(Intent(applicationContext,ModeStandardActivity::class.java))
        }
    }
}