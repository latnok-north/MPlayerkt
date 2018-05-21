package com.murphy.mplayer_kt.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.murphy.library.base.BaseLazyFragment
import com.murphy.library.base.BaseViewModel
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.databinding.FragmentListBinding

/**
 * Created by murphy on 2018/4/1.
 */
abstract class BaseItemListFragment<VM : BaseViewModel> : BaseLazyFragment<FragmentListBinding, VM>() {

    abstract fun generateAdapter(): RecyclerView.Adapter<*>
    abstract fun onBaseItemViewCreated()


    override fun onLazyLoad() {
        onBaseItemViewCreated()
        mBinding.recyclerView.adapter = generateAdapter()
        mBinding.recyclerView.layoutManager = generateLayoutManager()
    }

    open fun generateLayoutManager(): RecyclerView.LayoutManager {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.isSmoothScrollbarEnabled = true
        return linearLayoutManager
    }

    override val layoutId: Int
        get() = R.layout.fragment_list
}