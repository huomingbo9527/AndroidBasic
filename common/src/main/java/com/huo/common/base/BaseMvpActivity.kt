package com.ihealth.chronos.patient.base.base

import android.os.Bundle
import com.huo.common.base.BaseActivity

abstract class BaseMvpActivity<P : IPresenter> : BaseActivity(){
    protected lateinit var mPresenter: P
    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = injectPresenter()
        super.onCreate(savedInstanceState)

    }

    abstract fun injectPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

}
