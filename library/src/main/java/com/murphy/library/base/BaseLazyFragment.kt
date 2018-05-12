package com.murphy.library.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.murphy.library.utils.LogUtils

/**
 * Created by murphy on 2018/3/31.
 */
abstract class BaseLazyFragment<VB : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VB, VM>() {

    var isViewCreated = false
    var isViewVisible = false
    var isInitData = false

    abstract fun onLazyLoad()

    override fun onBaseViewCreated(savedInstanceState: Bundle?) {
        isViewCreated = true
        lazyLoad()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isViewVisible = true
            lazyLoad()
        } else {
            isViewVisible = false
        }
    }

    private fun lazyLoad() {
        if (!isInitData && isViewCreated && isViewVisible) {
            onLazyLoad()
            LogUtils.i(TAG, "onLazyLoad")
            isInitData = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreated = false
    }
}