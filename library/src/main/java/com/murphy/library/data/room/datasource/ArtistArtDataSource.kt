package com.murphy.library.data.room.datasource

import com.murphy.library.data.model.ArtistArtModel
import io.reactivex.Single

interface ArtistArtDataSource {

    fun getArtistArtById(id: Long): Single<ArtistArtModel>
    fun addArtistArt(model: ArtistArtModel)
    fun deleteArtistArt(model: ArtistArtModel)
}