package com.murphy.mplayer_kt.ui.fragment.artist

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.murphy.library.adapter.SpacesItemDecoration
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.viewmodel.ArtistViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class ArtistFragment : BaseItemListFragment<ArtistViewModel>() {
    override fun initViewModel(): ArtistViewModel {
        return ArtistViewModel()
    }

    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return viewModel.mAdapter
    }

    override fun generateLayoutManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(activity!!, 2)
    }

    override fun onBaseItemViewCreated() {
        initView()
        initData()
    }

    private fun initView() {
        val spacingInPixels = activity!!.resources.getDimensionPixelSize(R.dimen.spacing_card_album_grid)
        mBinding.recyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))
    }

    private fun initData() {
        viewModel.loadData(activity!!)
    }
}