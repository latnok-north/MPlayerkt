package com.murphy.library.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.murphy.library.utils.LogUtils

/**
 * Created by murphy on 2018/3/31.
 */

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    val TAG = this.javaClass.simpleName

    abstract val layoutId: Int
    var mRootView: View? = null
    protected lateinit var mBinding: VB
    protected lateinit var viewModel: VM
    abstract fun onBaseViewCreated(savedInstanceState: Bundle?)
    abstract fun initViewModel(): VM
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mBinding = DataBindingUtil.inflate(inflater, layoutId, null, false)
            mRootView = mBinding.root
            viewModel = initViewModel()
        }
        LogUtils.i(TAG, "onCreateView")
        return mRootView
    }

    fun getToolbar(): Toolbar? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.i(TAG, "onCreate")
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.i(TAG, "onViewCreated")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onBaseViewCreated(savedInstanceState)
        LogUtils.i(TAG, "onActivityCreated")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        LogUtils.i(TAG, "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtils.i(TAG, "onDetach")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.i(TAG, "onPause")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.i(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.i(TAG, "onStop")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.i(TAG, "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.i(TAG, "onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.i(TAG, "onDestroyView")
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        LogUtils.i(TAG, "setUserVisibleHint:$isVisibleToUser")
    }
}