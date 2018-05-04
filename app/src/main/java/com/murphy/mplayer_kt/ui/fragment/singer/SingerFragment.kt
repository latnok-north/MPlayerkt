package com.murphy.mplayer_kt.ui.fragment.singer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.murphy.library.data.model.SingerModel
import com.murphy.library.utils.LogUtils
import com.murphy.mplayer_kt.ui.adapter.SingerAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.fragment.song.SongViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class SingerFragment : BaseItemListFragment() {
    lateinit var mAdapter: SingerAdapter
    lateinit var mList: ArrayList<SingerModel>

    lateinit var mModel: SongViewModel

    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun onBaseItemViewCreated() {

        mModel = ViewModelProviders.of(activity!!).get(SongViewModel::class.java)

        mList = ArrayList()
        for (i in 0..19) {
            mList.add(SingerModel("第" + i + "首"))
        }
        mAdapter = SingerAdapter(activity!!, mList)

        mModel.getValue()?.observe(this, Observer { t ->
            if (t != null) {
                LogUtils.d("SingerFragment_vvv", t)
            }
        })
    }
}