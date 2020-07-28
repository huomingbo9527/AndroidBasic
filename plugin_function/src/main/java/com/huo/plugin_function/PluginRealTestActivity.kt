package com.huo.plugin_function

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/***
 * 运行本 plugin_function   将build文件拷贝到app的assert文件夹中。
 */
class PluginRealTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_plugin_test)
        Log.v("realPluginActivity","onCreate");
    }

    override fun onResume() {
        super.onResume()
        Log.v("realPluginActivity","onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.v("realPluginActivity","onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.v("realPluginActivity","onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("realPluginActivity","onDestroy");
    }


    override fun getResources(): Resources? {
        return if (application != null && application.resources != null) application.resources else super.getResources()
    }
}