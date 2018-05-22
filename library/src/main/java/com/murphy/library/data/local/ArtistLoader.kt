package com.murphy.library.data.local

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.helper.PreferenceHelper

class ArtistLoader {

    companion object {
        fun getAllArtist(context: Context): ArrayList<ArtistModel> {
            return getArtistFromCursor(makeArtistCursor(context, null, null))
        }

        fun getArtistById(context: Context, id: Long): ArtistModel? {
            val list = getArtistFromCursor(makeArtistCursor(context, "_id=?", arrayOf(id.toString())))
            if (list.size > 0) {
                return list[0]
            } else {
                return null
            }
        }

        fun getArtistLikeName(context: Context, paramString: String): ArrayList<ArtistModel> {
            return getArtistFromCursor(makeArtistCursor(context, "artist LIKE ?", arrayOf("%$paramString%")))
        }

        private fun getArtistFromCursor(cursor: Cursor?): ArrayList<ArtistModel> {
            val list = ArrayList<ArtistModel>()

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    val model = ArtistModel(cursor.getLong(0), cursor.getString(1), "", cursor.getInt(2), cursor.getInt(3), "")
                    list.add(model)
                } while (cursor.moveToNext())

                cursor.close()
            }

            return list
        }

        private fun makeArtistCursor(context: Context, selection: String?, paramArrayOfString: Array<String>?): Cursor? {
            val artistSortOrder = PreferenceHelper.getInstance(context).getArtistSortOrder()
            return context.contentResolver.query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, arrayOf("_id", "artist", "number_of_albums", "number_of_tracks"), selection, paramArrayOfString, artistSortOrder)
        }
    }


}