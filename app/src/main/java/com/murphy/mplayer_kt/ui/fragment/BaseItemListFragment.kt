package com.murphy.mplayer_kt.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.murphy.library.base.BaseLazyFragment
import com.murphy.mplayer_kt.R
import kotterknife.bindView

/**
 * Created by murphy on 2018/4/1.
 */
abstract class BaseItemListFragment : BaseLazyFragment() {

    val refreshLayout: SwipeRefreshLayout by bindView(R.id.refreshLayout)
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val btnUpdate: Button by bindView(R.id.btnUpdate)

    abstract fun generateAdapter(): RecyclerView.Adapter<*>
    abstract fun onBaseItemViewCreated()


    override fun onLazyLoad() {
        onBaseItemViewCreated()
        recyclerView.adapter = generateAdapter()
        recyclerView.layoutManager = generateLayoutManager()
    }

    open fun generateLayoutManager(): RecyclerView.LayoutManager {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.isSmoothScrollbarEnabled = true
        return linearLayoutManager
    }

    override val layoutId: Int
        get() = R.layout.fragment_list
}