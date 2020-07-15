package com.ihealth.chronos.patient.base.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ihealth.chronos.patient.base.App
import com.ihealth.chronos.patient.base.R
import com.ihealth.chronos.patient.base.base.page.IPageStateView
import com.ihealth.chronos.patient.base.util.extension.dismissDialogLoadingGlobal
import com.ihealth.chronos.patient.base.util.extension.showDialogLoadingGlobal
import io.reactivex.annotations.NonNull
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

abstract class BaseFragment: LazyLoadBaseFragment(),EasyPermissions.PermissionCallbacks,IBaseView{

    /**
     * 多种状态的 View 的切换
     */
    private var mPageStateView: IPageStateView? = null

    protected var mContext: Context? = null

    protected var mRootView:View? = null

    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        lazyLoad()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView =  inflater.inflate(getLayoutId(),null)
        initView()
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initData()
        mPageStateView = initPageStateView()
        //多种状态切换的view 重试点击事件
        mPageStateView?.setOnRetryClickListener(mRetryClickListener)
        initListener()
        super.onActivityCreated(savedInstanceState)

    }

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId():Int


    abstract fun initData()

    /**
     * 初始化界面状态view
     */
    abstract fun initPageStateView(): IPageStateView?

    protected open fun <T:View> findViewById(res:Int):T? {
       return mRootView?.findViewById(res)
    }

    protected open fun initView() {
    }

    protected open fun initListener() {
        mPageStateView?.setOnRetryClickListener(mRetryClickListener)
    }

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
                    activity?.let { if(!it.isFinishing  && isAdded)  mPageStateView?.showNoNetwork()}
                },300)
            }
        }
    }


    override fun showDialogLoading() {
        showDialogLoadingGlobal(activity)
    }

    override fun dismissDialogLoading() {
        dismissDialogLoadingGlobal()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        mContext = null
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(myEvent: Any) {
    }


    /**
     * Call [Activity.startActivityForResult] from the fragment's
     * containing Activity.
     */
    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        startActivityForResult(intent, requestCode, null)
        activity?.overridePendingTransition(R.anim.common_activity_push_left_in, R.anim.common_fade_out_half)
    }

    /**
     * Call [Activity.startActivity] from the fragment's
     * containing Activity.
     */
    override fun startActivity(intent: Intent) {
        startActivity(intent, null)
        activity?.overridePendingTransition(R.anim.common_activity_push_left_in, R.anim.common_fade_out_half)
    }

    /**
     * 重写要申请权限的Activity或者Fragment的onRequestPermissionsResult()方法，
     * 在里面调用EasyPermissions.onRequestPermissionsResult()，实现回调。
     *
     * @param requestCode  权限请求的识别码
     * @param permissions  申请的权限
     * @param grantResults 授权结果
     */
    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    /**
     * 当权限被成功申请的时候执行回调
     *
     * @param requestCode 权限请求的识别码
     * @param perms       申请的权限的名字
     */
    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        Log.i("EasyPermissions", "获取成功的权限$perms")
    }

    /**
     * 当权限申请失败的时候执行的回调
     *
     * @param requestCode 权限请求的识别码
     * @param perms       申请的权限的名字
     */
    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        //处理权限名字字符串
        val sb = StringBuffer()
        for (str in perms) {
            sb.append(str)
            sb.append("\n")
        }
        sb.replace(sb.length - 2, sb.length, "")
        //用户点击拒绝并不在询问时候调用
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            Toast.makeText(activity, "已拒绝权限" + sb + "并不再询问", Toast.LENGTH_SHORT).show()
            AppSettingsDialog.Builder(this)
                    .setRationale("此功能需要" + sb + "权限，否则无法正常使用，是否打开设置")
                    .setPositiveButton("好")
                    .setNegativeButton("不行")
                    .build()
                    .show()
        }
    }
}
