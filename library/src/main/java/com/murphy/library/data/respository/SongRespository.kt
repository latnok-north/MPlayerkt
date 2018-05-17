package com.murphy.library.data.respository

import android.content.Context
import android.util.Log
import com.murphy.library.data.local.SongLoader
import com.murphy.library.data.model.SongModel
import com.murphy.library.helper.MusicHelper
import com.murphy.library.helper.PreferenceHelper
import com.murphy.library.utils.RxJavaUtils
import io.reactivex.Observable

class SongRespository {

    fun getAllSongs(context: Context): Observable<ArrayList<SongModel>> {
        return Observable.create<ArrayList<SongModel>> { e ->
            Log.e("Observable", Thread.currentThread().name)
            if (PreferenceHelper.getInstance(context).isFirstQueryFolders()) {

            }
            val list = SongLoader.getAllSong(context)
            e.onNext(list)
            e.onComplete()
        }.compose(RxJavaUtils.setThread())
    }
}