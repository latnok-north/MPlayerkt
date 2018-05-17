package com.murphy.library.data.model

//import io.objectbox.annotation.Entity
//import io.objectbox.annotation.Id

/**
 * Created by murphy on 2018/4/6.
 */
//@Entity
data class SongModel(var id: Long,
                     var title: String,
                     var displayName: String,
                     var artist: String,
                     var album: String,
                     var path: String,
                     var duration: Long,
                     var size: Long,
                     var artistId: Long,
                     var albumId: Long,
                     var trackNumber: Int)