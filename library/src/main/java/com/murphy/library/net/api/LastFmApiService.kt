package com.murphy.library.net.api

import com.murphy.library.net.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmApiService {

    @GET(ApiConstants.getArtistInfo)
    fun getArtistInfo(@Query("artist") artist:String)
}