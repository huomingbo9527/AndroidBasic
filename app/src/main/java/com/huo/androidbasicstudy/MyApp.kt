package com.huo.androidbasicstudy

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MyApp : Application() {

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