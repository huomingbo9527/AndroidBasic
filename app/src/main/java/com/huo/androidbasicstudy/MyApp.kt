package com.huo.androidbasicstudy

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import com.huo.androidbasicstudy.activity.plugin.other.HookHelper
import com.huo.androidbasicstudy.activity.plugin.other.PluginHelper




class MyApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        HookHelper.hookInstrumentation(base)
    }
    override fun getResources(): Resources? {
        return if (PluginHelper.getPluginResources() == null) super.getResources() else PluginHelper.getPluginResources()
    }


    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityTaskCallback())
    }


    class ActivityTaskCallback : ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityDestroyed(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }
        override fun onActivityResumed(activity: Activity) {
            Log.d("ActivityTask","onActivityResumed+"+activity::class.java.simpleName +"####taskid = "+activity.taskId);
        }
    }
}