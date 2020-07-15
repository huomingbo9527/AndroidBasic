package com.ihealth.chronos.patient.base.base.error

import com.ihealth.chronos.patient.base.base.PageState


/**
 * 界面接口异常，包括网络异常，接口异常，业务处理等
 */
data class ApiException(override var message: String?,var code: Int,var pageState: PageState = PageState.ERROR) : Exception(message)