package com.huo.androidbasicstudy.activity.android_compat

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.huo.androidbasicstudy.R
import com.huo.androidbasicstudy.util.logV
import kotlinx.android.synthetic.main.activity_tem_compat.*

class TenCompatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tem_compat)
        tenCompatContent.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }


    override fun onConfigurationChanged(@NonNull newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val currentNightMode =
            newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                logV("onConfigurationChanged  暗")
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                logV("onConfigurationChanged  亮")
            }
            else -> {

            }
        }
    }
}