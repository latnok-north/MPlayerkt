package com.murphy.library.data.model

//import io.objectbox.annotation.Entity
//import io.objectbox.annotation.Id
//import java.util.*

/**
 * Created by murphy on 2018/4/6.
 */
data class FolderModel(var id: Int,
                       var name: String,
                       var path: String,
                       var numOfSongs: Int,
                       var createdAt: String,
                       var songs: List<SongModel>?)