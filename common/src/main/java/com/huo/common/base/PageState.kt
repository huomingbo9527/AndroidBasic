package com.ihealth.chronos.patient.base.base

/***
 * 界面显示状态
 */
enum class PageState {
    LOADING,//加载中
    END,
    SUCCESS,//显示界面内容
    EMPTY,//空页面
    ERROR,//服务器error 界面错误
    ERROR_NET//网络error 界面错误
}