package com.murphy.library.data.room.local

import com.murphy.library.base.MPApplication
import com.murphy.library.data.model.ArtistArtModel
import com.murphy.library.data.room.AppDatabase
import com.murphy.library.data.room.dao.ArtistArtModelDao
import com.murphy.library.data.room.datasource.ArtistArtDataSource
import com.murphy.library.rx.BaseObserver
import com.murphy.library.utils.RxJavaUtils
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class LocalArtistArtDataSource : ArtistArtDataSource {

    val dao : ArtistArtModelDao = AppDatabase.getInstance(MPApplication.mInstance.applicationContext)
            .getArtistArtModelDao()

    override fun getArtistArtById(id: Long): Single<ArtistArtModel> {
        return dao.getArtistArtById(id).compose(RxJavaUtils.transformerForSinger())
    }

    override fun addArtistArt(model: ArtistArtModel) {
        AppDatabase.getInstance(MPApplication.mInstance.applicationContext).postRunnable(Runnable {
            dao.addArtistArt(model)
        })
    }

    override fun deleteArtistArt(model: ArtistArtModel) {

        AppDatabase.getInstance(MPApplication.mInstance.applicationContext).postRunnable(Runnable {
            dao.deleteArtistArt(model)
        })
    }


}