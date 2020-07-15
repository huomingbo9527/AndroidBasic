package com.ihealth.chronos.patient.base.base

interface IBaseView {
    /**
     * 界面内加载
     */
    fun showPageLoading()
    /**
     * 关闭界面内加载，显示界面内容
     */
    fun completePageLoading(pageState : PageState)

    /**
     * 界面外弹窗加载
     */
    fun showDialogLoading()
    /**
     * 关闭界面外弹窗加载
     */
    fun dismissDialogLoading()
}
