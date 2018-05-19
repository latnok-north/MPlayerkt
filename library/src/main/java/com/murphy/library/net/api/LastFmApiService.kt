package com.murphy.library.net.api

import com.murphy.library.data.model.ArtistArtModel
import com.murphy.library.data.model.NewArtistModel
import com.murphy.library.net.ApiConstants
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface LastFmApiService {

    @GET
    fun getArtistInfo(@Url url: String, @Query("artist") artist: String): Observable<NewArtistModel>
}