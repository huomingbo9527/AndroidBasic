package com.huo.androidbasicstudy.activity.life

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.huo.androidbasicstudy.R
import com.huo.androidbasicstudy.event.EventActivity
import com.huo.androidbasicstudy.util.logV
import kotlinx.android.synthetic.main.activity_a.*

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        buttonName.setOnClickListener {
            val intent = Intent(applicationContext, BActivity::class.java)
            startActivity(intent)
        }
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")
    }


    override fun onRestart() {
        super.onRestart()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")
    }

    override fun onStart() {
        super.onStart()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")
    }

    override fun onResume() {
        super.onResume()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")

    }

    override fun onPause() {
        super.onPause()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")

    }

    override fun onStop() {
        super.onStop()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")

    }

    override fun onDestroy() {
        super.onDestroy()
        logV("${this.javaClass.simpleName}    ${EventActivity.getExecutingMethodName()}  ")
    }
}