package com.murphy.library.data.local

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.text.TextUtils
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.helper.PreferenceHelper

class SongLoader {
    companion object {
        fun getAllSong(context: Context): ArrayList<SongModel> {
            return getSongFromCursor(makeSongCursor(context, null, null))
        }

        fun searchSongs(context: Context, searchString: String): ArrayList<SongModel> {
            return getSongFromCursor(makeSongCursor(context, "title LIKE ? or artist LIKE ? or album LIKE ? ",
                    arrayOf("%$searchString%", "%$searchString%", "%$searchString%")))
        }

        fun getSongListInFolder(context: Context, path: String): ArrayList<SongModel> {
            val whereArgs = arrayOf("$path%")
            return getSongFromCursor(makeSongCursor(context, MediaStore.Audio.Media.DATA + " LIKE ?", whereArgs, null))
        }

        private fun getSongFromCursor(cursor: Cursor?): ArrayList<SongModel> {
            val list = ArrayList<SongModel>()

            if (cursor != null && cursor.moveToFirst()) {
                do {

                    val id = cursor.getLong(0)
                    val title = cursor.getString(1)
                    val artist = cursor.getString(2)
                    val album = cursor.getString(3)
                    val duration = cursor.getInt(4).toLong()
                    val trackNumber = cursor.getInt(5)
                    val artistId = cursor.getInt(6).toLong()
                    val albumId = cursor.getLong(7)
                    val path = cursor.getString(8)
                    var size = cursor.getInt(9).toLong()
                    var model = SongModel(id, title, title, artist, album, path, duration, size, artistId, albumId, trackNumber)

                    list.add(model)
                } while (cursor.moveToNext())

                cursor.close()
            }

            return list
        }

        private fun makeSongCursor(context: Context, selection: String?, paramArrayOfString: Array<String>?): Cursor? {
            val songSortOrder = PreferenceHelper.getInstance(context).getSongSortOrder()
            return makeSongCursor(context, selection, paramArrayOfString, songSortOrder)
        }

        private fun makeSongCursor(context: Context, selection: String?, paramArrayOfString: Array<String>?, sortOrder: String?): Cursor? {
            var selectionStatement = "is_music=1 AND title != ''"

            if (!TextUtils.isEmpty(selection)) {
                selectionStatement = "$selectionStatement AND $selection"
            }
            return context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf("_id", "title", "artist", "album", "duration", "track", "artist_id", "album_id", MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.SIZE),
                    selectionStatement, paramArrayOfString, sortOrder)
        }
    }
}