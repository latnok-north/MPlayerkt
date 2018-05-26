package com.murphy.mplayer_kt.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.murphy.library.base.BaseViewModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.data.respository.SongRespository
import com.murphy.library.rx.BaseObserver
import com.murphy.mplayer_kt.ui.adapter.SongAdapter

class SongViewModel : BaseViewModel() {
    private var respository: SongRespository


    var mAdapter: SongAdapter
    var mList: ArrayList<SongModel> = ArrayList()

    init {
        respository = SongRespository()
        mAdapter = SongAdapter(mList, this)
    }

    fun loadSongList(mContext: Context) {
        loadMusic(mContext)
    }

    private fun loadMusic(mContext: Context) {
        respository.getAllSongs(mContext).subscribe(object : BaseObserver<ArrayList<SongModel>>() {
            override fun onSuccess(t: ArrayList<SongModel>) {
                mList.clear()
                mList.addAll(t)
                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(e: Throwable) {
                mAdapter.notifyDataSetChanged()
            }

        })
    }
}