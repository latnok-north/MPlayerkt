package com.murphy.library.data.room.dao

import android.arch.persistence.room.*
import com.murphy.library.data.model.ArtistArtModel
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface ArtistArtModelDao {


    @Query("select * from artist_art")
    fun getArtistList(): Maybe<List<ArtistArtModel>>

    @Query("select * from artist_art where id = :id")
    fun getArtistArtById(id: Long): Single<ArtistArtModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArtistArt(model: ArtistArtModel)

    @Delete()
    fun deleteArtistArt(model: ArtistArtModel)
}