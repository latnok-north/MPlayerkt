package com.murphy.library.data.model

/**
 * Created by murphy on 2018/4/5.
 */

data class ArtistModel(var id: Long,
                       var name: String,
                       var image: String,
                       var albumCount: Int,
                       var songCount: Int,
                       var url: String?)