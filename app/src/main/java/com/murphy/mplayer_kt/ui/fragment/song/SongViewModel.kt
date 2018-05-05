package com.murphy.mplayer_kt.ui.fragment.song

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.murphy.library.base.BaseViewModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.data.source.LocalDataSource
import com.murphy.library.rx.BaseObserver

class SongViewModel : BaseViewModel() {

    var mSongs: MutableLiveData<ArrayList<SongModel>>? = null
    var dataSource: LocalDataSource? = null

    var mUpdateValue: MutableLiveData<String>? = null

    fun setValue(item: String) {
        if (mUpdateValue == null) {
            mUpdateValue = MutableLiveData()
        }
        mUpdateValue?.value = item
    }

    fun getValue() : LiveData<String>? {
        return mUpdateValue
    }

    fun getSongList(mContext: Context) : LiveData<ArrayList<SongModel>>?{
        if (mSongs == null) {
            mSongs = MutableLiveData()
            loadMusic(mContext)
        }
        return mSongs
    }

    private fun loadMusic(mContext: Context) {
        if (dataSource == null) {
            dataSource = LocalDataSource()
        }
        dataSource?.scanMusic(mContext)!!.subscribe(object : BaseObserver<ArrayList<SongModel>>() {

            @Throws(Exception::class)
            override fun onSuccess(folders: ArrayList<SongModel>) {
//                mAdapter.addData(folders as MutableList<SongModel>)
//                mAdapter.notifyDataSetChanged()
                mSongs?.value = folders
            }

            @Throws(Exception::class)
            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {

            }
        })
    }

    private fun loadArtist(mContext: Context) {
        if (dataSource == null) {
            dataSource = LocalDataSource()
        }

        dataSource?.scanArtist(mContext)!!.subscribe(object : BaseObserver<ArrayList<ArtistModel>>() {
            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {

            }

            override fun onSuccess(t: ArrayList<ArtistModel>) {

            }

        })
    }
}