package com.murphy.mplayer_kt.ui.fragment.artist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.utils.LogUtils
import com.murphy.mplayer_kt.ui.adapter.ArtistAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.viewmodel.ArtistViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class ArtistFragment : BaseItemListFragment<ArtistViewModel>() {
    override fun initViewModel(): ArtistViewModel {
        return ArtistViewModel()
    }

    lateinit var mAdapter: ArtistAdapter
    lateinit var mList: ArrayList<ArtistModel>

    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun generateLayoutManager(): RecyclerView.LayoutManager {
        return GridLayoutManager(activity!!, 2)
    }

    override fun onBaseItemViewCreated() {

//        mModel = ViewModelProviders.of(activity!!).get(SongViewModel::class.java)

        mList = ArrayList()
        for (i in 0..19) {
            mList.add(ArtistModel("第" + i + "首"))
        }
        mAdapter = ArtistAdapter(activity!!, mList)

//        mModel.getValue()?.observe(this, Observer { t ->
//            if (t != null) {
//                LogUtils.d("SingerFragment_vvv", t)
//            }
//        })
    }
}