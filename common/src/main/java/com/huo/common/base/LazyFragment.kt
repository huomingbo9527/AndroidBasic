//package com.ihealth.chronos.patient.base.base
//
//import android.os.Bundle
//import com.ihealth.chronos.patient.base.util.extension.logVerbose
//
///**
// * 界面显示给用户才执行数据加载、界面刷新操作
// */
//open class LazyFragment: LazyLoadBaseFragment(){
////
////    /**
////     * 视图是否加载完毕
////     */
////    private var isViewPrepare = false
////    /**
////     * 数据是否加载过了
////     */
////    private var hasLoadData = false
////
////    /**
////     * 是否调用了onResume()方法
////     */
////    private var isResume = false
////    private var curLazyResumeTime = 0L
////
////    /**
////     * 子类onActivityCreated如果执行数据出事话操作的话要在super.onActivityCreated之前初始化
////     */
////    override fun onActivityCreated(savedInstanceState: Bundle?) {
////        super.onActivityCreated(savedInstanceState)
////        isViewPrepare = true
////        lazyLoadDataIfPrepared()
////    }
////
////    /***
////     * 该方法FragmentPagerAdapter调用
////     */
////    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
////        super.setUserVisibleHint(isVisibleToUser)
////        if (isVisibleToUser) {
////            lazyLoadDataIfPrepared()
////            lazyUpdateDataOnResume()
////        }
////    }
////
////    override fun onHiddenChanged(hidden: Boolean) {
////        super.onHiddenChanged(hidden)
////        if(!hidden){
////            lazyUpdateDataOnResume()
////        }
////    }
////
////
////    override fun onResume() {
////        super.onResume()
////        isResume = true
////        lazyUpdateDataOnResume()
////    }
////
////    override fun onPause() {
////        super.onPause()
////        isResume = false
////    }
////
////
////    /**
////     * 第一此懒加载，界面显示在前台时候才加载数据
////     */
////    private fun lazyLoadDataIfPrepared() {
////        if (userVisibleHint && isViewPrepare && !hasLoadData) {
////            lazyLoad()
////            hasLoadData = true
////        }
////    }
////
////    /**
////     * 显示界面并刷新ui
////     * userVisibleHint = true  setUserVisibleHint(isVisibleToUser: Boolean)
////     * isViewPrepare = true    onViewCreated
////     * hasLoadData = true      lazyLoadDataIfPrepared
////     * isVisible  = true       isVisible()
////     */
////    private fun lazyUpdateDataOnResume() {
////        if(System.currentTimeMillis() - curLazyResumeTime < 200){//过滤重复调用
////            return
////        }
////        curLazyResumeTime = System.currentTimeMillis()
////        if (userVisibleHint && isViewPrepare && hasLoadData && isResume && isVisible) {//第一此onResume()时isVisible = false 初始化时候该判断false
//////            var parentHide = false
//////            var parent:Fragment? = parentFragment
//////            while (parent != null){
//////                if (parent.isHidden || !parent.userVisibleHint || !parent.isVisible){
//////                    parentHide = true
//////                    break
//////                }
//////                parent = parent.parentFragment
//////            }
//////            if(!parentHide)
////            onResumeLazy()
////        }
////    }
////
//    /**
//     * 懒加载：加载界面的初始化数据
//     */
//    override open fun lazyLoad(){
//
//    }
//
////    /**
////     * 执行fragment回到前端刷新数据优化
////     */
////    protected open fun onResumeLazy() {
////        logVerbose("Fragment  onResumeLazy  未使用")
//////        childFragmentManager.fragments
////    }
//}
