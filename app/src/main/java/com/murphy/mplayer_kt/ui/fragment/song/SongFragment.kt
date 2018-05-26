package com.murphy.mplayer_kt.ui.fragment.artist


import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import com.murphy.library.adapter.DividerItemDecoration
import com.murphy.library.data.model.SongModel
import com.murphy.mplayer_kt.ui.adapter.SongAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.viewmodel.SongViewModel


/**
 * Created by murphy on 2018/4/1.
 */
class SongFragment : BaseItemListFragment<SongViewModel>() {

    override fun initViewModel(): SongViewModel {
        return SongViewModel()
    }

    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return viewModel.mAdapter
    }

    override fun onBaseItemViewCreated() {
        mBinding.recyclerView.addItemDecoration(DividerItemDecoration(activity!!, DividerItemDecoration.VERTICAL_LIST, true))
        viewModel.loadSongList(activity!!)
    }
}