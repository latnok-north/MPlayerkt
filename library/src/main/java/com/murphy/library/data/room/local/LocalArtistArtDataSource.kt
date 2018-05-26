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

    var dao : ArtistArtModelDao = AppDatabase.getInstance(MPApplication.mInstance.applicationContext)
            .getArtistArtModelDao()

    override fun getArtistArtById(id: Long): Single<ArtistArtModel> {
        return dao.getArtistArtById(id).compose(RxJavaUtils.transformerForSinger())
    }

    override fun addArtistArt(model: ArtistArtModel) {
        Observable.create<Int>({e ->
            dao.addArtistArt(model)
            e.onNext(1)
            e.onComplete()
        }).compose(RxJavaUtils.transformerForObservable()).subscribe(object : BaseObserver<Int>() {
            override fun onSuccess(t: Int) {

            }

            override fun onFailure(e: Throwable) {

            }

        })

    }

    override fun deleteArtistArt(model: ArtistArtModel) {
        dao.deleteArtistArt(model)
    }


}