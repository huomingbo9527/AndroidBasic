package com.huo.androidbasicstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.huo.androidbasicstudy.activity.plugin.other.PluginTestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, PluginTestActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
        var viewGroup:ViewGroup
        var view: View
    }
}