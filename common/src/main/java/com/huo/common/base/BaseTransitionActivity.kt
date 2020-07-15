package com.ihealth.chronos.patient.base.base

import android.content.Intent
import com.ihealth.chronos.patient.base.R

/***
 * 界面跳转过度动画
 */
abstract class BaseTransitionActivity : androidx.fragment.app.FragmentActivity() {

    override fun startActivity(intent: Intent) {
        this.startActivity(intent, null)
        overridePendingTransition(R.anim.common_activity_push_left_in, R.anim.common_fade_out_half)
    }


    /**
     * Call this when your activity is done and should be closed.  The
     * ActivityResult is propagated back to whoever launched you via
     * onActivityResult().
     */
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.common_activity_fade_in, R.anim.common_activity_push_right_out)
    }

    fun finishNoAnim() {
        super.finish()
    }

    /**
     * 关闭Frament
     */
    protected open fun finishSelf(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.common_activity_push_left_in,
                        R.anim.common_activity_push_left_out, R.anim.common_activity_push_left_in,
                        R.anim.common_activity_push_left_out)
                .remove(fragment).commit()
    }
}


