package com.murphy.mplayer_kt.ui.fragment.artist


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.RecyclerView
import com.murphy.library.adapter.DividerItemDecoration
import com.murphy.library.data.model.SongModel
import com.murphy.mplayer_kt.ui.adapter.SongAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.fragment.song.SongViewModel


/**
 * Created by murphy on 2018/4/1.
 */
class SongFragment : BaseItemListFragment() {

    lateinit var mModel: SongViewModel

    lateinit var mAdapter: SongAdapter
    lateinit var mList: ArrayList<SongModel>
    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun onBaseItemViewCreated() {
        mModel = ViewModelProviders.of(activity!!).get(SongViewModel::class.java)


        mList = ArrayList()
        mAdapter = SongAdapter(activity!!, mList)
        recyclerView.addItemDecoration(DividerItemDecoration(activity!!, DividerItemDecoration.VERTICAL_LIST, true))
        mModel.getSongList(activity!!)?.observe(this, Observer<ArrayList<SongModel>> { t ->
            mAdapter.addData(t!!)
            mAdapter.notifyDataSetChanged()
        })

        btnUpdate.setOnClickListener({
            mModel.setValue(System.currentTimeMillis().toString())
        })
    }


}