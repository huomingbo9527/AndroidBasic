package com.huo.nest.behavior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.huo.nest.R

class BehaviorTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_behavior_test)
        var appbar : AppBarLayout? = null
        var b : CollapsingToolbarLayout? = null
        var body: CoordinatorLayout? = null
    }
}