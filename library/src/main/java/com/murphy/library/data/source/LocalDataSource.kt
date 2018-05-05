package com.murphy.library.data.source

import android.content.Context
import android.util.Log
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.helper.MusicHelper
import com.murphy.library.helper.PreferenceHelper
import com.murphy.library.utils.RxJavaUtils
import io.reactivex.Observable

/**
 * Created by murphy on 2018/4/7.
 */
class LocalDataSource {

    fun scanMusic(context: Context): Observable<ArrayList<SongModel>> {
        return Observable.create<ArrayList<SongModel>> { e ->
            Log.e("Observable", Thread.currentThread().name)
            if (PreferenceHelper.isFirstQueryFolders(context)) {

            }

            val list = MusicHelper.getMusicData(context)
            e.onNext(list)
            e.onComplete()
        }.compose(RxJavaUtils.setThread())
    }

    fun scanArtist(context: Context): Observable<ArrayList<ArtistModel>> {
        return Observable.create<ArrayList<ArtistModel>> {
            e ->
            var list = MusicHelper.getArtists(context)
            e.onNext(list)
            e.onComplete()
        }
    }
}