package com.murphy.library.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "artist_art")
data class ArtistArtModel constructor(@PrimaryKey var id: Long,
                          var small: String,
                          var medium: String,
                          var large: String,
                          var extraLarge: String)