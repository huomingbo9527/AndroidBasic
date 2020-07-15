package com.huo.common.base

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.ihealth.chronos.patient.base.App
import com.ihealth.chronos.patient.base.base.BaseTransitionActivity
import com.ihealth.chronos.patient.base.base.IBaseView
import com.ihealth.chronos.patient.base.base.PageState
import com.ihealth.chronos.patient.base.base.page.IPageStateView
import com.ihealth.chronos.patient.base.util.ActivityCollector
import com.ihealth.chronos.patient.base.util.extension.*
import org.greenrobot.eventbus.EventBus
import java.lang.ref.WeakReference
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe




abstract class BaseActivity : BaseTransitionActivity(),
    IBaseView//,EasyPermissions.PermissionCallbacks
{

    companion object {
        private const val TAG = "BaseActivity"
    }

    /**
     * 多种状态的 View 的切换
     */
    protected var mPageStateView: IPageStateView? = null

    /**
     * 判断当前Activity是否在前台。
     */
    protected var isActive: Boolean = false

    /**
     * 当前Activity的实例。
     */
    protected open var activity: Activity? = null

    /**
     * 当前Activity的弱引用。
     */
    private var weakRefActivity: WeakReference<Activity>? = null

    /***
     * 是否显示状态栏
     */
    protected var showStatusBar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        weakRefActivity = WeakReference(this)
        ActivityCollector.add(weakRefActivity)
        EventBus.getDefault().register(this)
        init()
        setContentView(layoutId())
        if(showStatusBar)
            setStatusBar()
        initView()
        mPageStateView = initPageStateView()
        initListener()
        initData()
        start()
    }

    private fun init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }


    /**
     * 设置状态栏
     */
    open protected fun setStatusBar() {

    }


    override fun onResume() {
        super.onResume()
        ActivityCollector.curActivityRef = WeakReference(this)
        isActive = true
//        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        isActive = false
//        MobclickAgent.onPause(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.remove(weakRefActivity)
        EventBus.getDefault().unregister(this)
    }
    //方便子类初始化View
    protected open fun initView() {

    }

    protected open fun initListener() {
        mPageStateView?.setOnRetryClickListener(mRetryClickListener)
    }

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }


    /**
     *  加载布局
     */
    abstract fun layoutId(): Int


    /**
     * 初始化界面状态view
     */
    abstract fun initPageStateView(): IPageStateView?

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 开始请求
     */
    abstract fun start()


    override fun showPageLoading() {
        mPageStateView?.showLoading()
    }


    override fun completePageLoading(pageState: PageState) {
        when(pageState){
            PageState.SUCCESS ->{
                mPageStateView?.showSuccessContent()
            }
            PageState.EMPTY ->{
                mPageStateView?.showEmpty()
            }
            PageState.ERROR ->{
                mPageStateView?.showError()
            }
            PageState.ERROR_NET ->{
                App.getHandler().postDelayed({
                    activity?.let { if(!it.isFinishing)  mPageStateView?.showNoNetwork()}
                },300)
            }
        }
    }

    override fun showDialogLoading(){
        showDialogLoadingGlobal(this)
    }

    override fun dismissDialogLoading(){
        dismissDialogLoadingGlobal()
    }


    /**
     * 隐藏软键盘。
     */
    fun hideSoftKeyboard() {
        try {
            val view = currentFocus
            if (view != null) {
                val binder = view.windowToken
                val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        } catch (e: Exception) {
            logWarn(TAG, e.message, e)
        }

    }

    /**
     * 显示软键盘。
     */
    fun showSoftKeyboard(editText: EditText?) {
        try {
            if (editText != null) {
                editText.requestFocus()
                val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.showSoftInput(editText, 0)
            }
        } catch (e: Exception) {
            logWarn(TAG, e.message, e)
        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(myEvent: Any) {

    }

    /***
     * 监听返回键，如果占不为0
     *
     * @param keyCode
     * @param event
     * @param backStackEntryCount 占
     * @return
     */
    fun onKeyDown(keyCode: Int, event: KeyEvent, backStackEntryCount: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && backStackEntryCount == 0) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


//    /**
//    * 重写要申请权限的Activity或者Fragment的onRequestPermissionsResult()方法，
//    * 在里面调用EasyPermissions.onRequestPermissionsResult()，实现回调。
//    *
//    * @param requestCode  权限请求的识别码
//    * @param permissions  申请的权限
//    * @param grantResults 授权结果
//    */
//    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
//    }
//
//    /**
//     * 当权限被成功申请的时候执行回调
//     *
//     * @param requestCode 权限请求的识别码
//     * @param perms       申请的权限的名字
//     */
//    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
//        Log.i("EasyPermissions", "获取成功的权限$perms")
//    }
//
//    /**
//     * 当权限申请失败的时候执行的回调
//     *
//     * @param requestCode 权限请求的识别码
//     * @param perms       申请的权限的名字
//     */
//    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
//        //处理权限名字字符串
//        val sb = StringBuffer()
//        for (str in perms) {
//            sb.append(str)
//            sb.append("\n")
//        }
//        sb.replace(sb.length - 2, sb.length, "")
//        //用户点击拒绝并不在询问时候调用
//        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
//            Toast.makeText(this, "已拒绝权限" + sb + "并不再询问", Toast.LENGTH_SHORT).show()
//            AppSettingsDialog.Builder(this)
//                    .setRationale("此功能需要" + sb + "权限，否则无法正常使用，是否打开设置")
//                    .setPositiveButton("好")
//                    .setNegativeButton("不行")
//                    .build()
//                    .show()
//        }
//    }

}


