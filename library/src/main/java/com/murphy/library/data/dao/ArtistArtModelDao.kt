package com.murphy.library.data.dao

import android.arch.persistence.room.*
import com.murphy.library.data.model.ArtistArtModel

@Dao
interface ArtistArtModelDao {


    @Query("select * from artist_art")
    fun getArtistList(): ArrayList<ArtistArtModel>

    @Query("select * from artist_art where id = :id")
    fun getArtistArtById(id: Long): ArtistArtModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArtistArt(model: ArtistArtModel)

    @Delete()
    fun deleteArtistArt(model: ArtistArtModel)
}