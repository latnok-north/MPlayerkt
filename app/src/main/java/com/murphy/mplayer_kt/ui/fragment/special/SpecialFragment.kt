package com.murphy.mplayer_kt.ui.fragment.special

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.RecyclerView
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.utils.LogUtils
import com.murphy.mplayer_kt.ui.adapter.ArtistAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.fragment.song.SongViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class SpecialFragment : BaseItemListFragment() {
    lateinit var mAdapter: ArtistAdapter
    lateinit var mList: ArrayList<ArtistModel>

    lateinit var mModel: SongViewModel

    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun onBaseItemViewCreated() {
        mList = ArrayList()
        mModel = ViewModelProviders.of(activity!!).get(SongViewModel::class.java)
        for (i in 0..19) {
            mList.add(ArtistModel("第" + i + "首"))
        }
        mAdapter = ArtistAdapter(activity!!, mList)

        mModel.getValue()?.observe(this, Observer { t ->
            if (t != null) {
                LogUtils.d("SpecialFragment_vvv", t)
            }
        })
    }
}