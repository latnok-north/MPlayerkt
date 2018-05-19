package com.murphy.mplayer_kt.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.murphy.library.base.BaseViewModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.data.respository.SongRespository
import com.murphy.library.rx.BaseObserver

class SongViewModel : BaseViewModel() {
    private var mSongs: MutableLiveData<ArrayList<SongModel>>
    private var respository: SongRespository

    var mUpdateValue: MutableLiveData<String>? = null

    init {
        respository = SongRespository()
        mSongs = MutableLiveData()
    }

    fun setValue(item: String) {
        if (mUpdateValue == null) {
            mUpdateValue = MutableLiveData()
        }
        mUpdateValue?.value = item
    }

    fun getValue(): LiveData<String>? {
        return mUpdateValue
    }

    fun getSongList(mContext: Context): LiveData<ArrayList<SongModel>> {
        loadMusic(mContext)
        return mSongs
    }

    private fun loadMusic(mContext: Context) {
        respository.getAllSongs(mContext).subscribe(object : BaseObserver<ArrayList<SongModel>>() {
            override fun onSuccess(t: ArrayList<SongModel>) {
                mSongs.value = t
            }

            override fun onFailure(e: Throwable) {

            }

        })
    }
}