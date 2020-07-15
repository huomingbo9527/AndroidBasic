package com.huo.common.base.page;

import android.view.View;

/***
 * 界面状态显示接口
 */
public interface IPageStateView {

    void showLoading();
    void showSuccessContent();
    void showEmpty();
    void showError();
    void showNoNetwork();
    void setOnRetryClickListener(View.OnClickListener listener);
}
