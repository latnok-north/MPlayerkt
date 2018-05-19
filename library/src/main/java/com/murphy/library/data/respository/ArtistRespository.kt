package com.murphy.library.data.respository

import android.content.Context
import android.util.Log
import com.murphy.library.Constants
import com.murphy.library.data.local.ArtistLoader
import com.murphy.library.data.model.ArtistArtModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.NewArtistModel
import com.murphy.library.helper.PreferenceHelper
import com.murphy.library.net.ApiConstants
import com.murphy.library.net.RetrofitClient
import com.murphy.library.net.api.LastFmApiService
import com.murphy.library.utils.RxJavaUtils
import io.reactivex.Observable

class ArtistRespository {

    fun getAllArtist(context: Context): Observable<ArrayList<ArtistModel>> {
        return Observable.create<ArrayList<ArtistModel>> { e ->
            Log.e("Observable", Thread.currentThread().name)
            if (PreferenceHelper.getInstance(context).isFirstQueryFolders()) {

            }
            val list = ArtistLoader.getAllArtist(context)
            e.onNext(list)
            e.onComplete()
        }.compose(RxJavaUtils.setThread())
    }

    fun getArtistImageModel(name: String): Observable<NewArtistModel> {
        val service = RetrofitClient.getInstance().create(LastFmApiService::class.java)
        return service.getArtistInfo(Constants.BASE_API_URL_LASTFM + ApiConstants.getArtistInfo, name).compose(RxJavaUtils.setThread())
    }
}