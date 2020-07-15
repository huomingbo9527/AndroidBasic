package com.ihealth.chronos.patient.base.base

import android.os.Bundle

abstract class BaseMvpFragment<P : IPresenter> : BaseFragment(){
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