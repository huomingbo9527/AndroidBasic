package com.huo.androidbasicstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import com.huo.androidbasicstudy.activity.android_compat.TenCompatActivity
import com.huo.androidbasicstudy.activity.life.AActivity
import com.huo.nest.button.TwoButtonEventActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, AActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
//        finish()
//        var viewGroup:ViewGroup
//        var view: View
//        val linkList:LinkedList<String> = LinkedList()
//        linkList.javaClass.superclass
//        val handler = Handler()

    }
}