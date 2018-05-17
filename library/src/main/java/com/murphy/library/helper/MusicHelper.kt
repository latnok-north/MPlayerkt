package com.murphy.library.helper

import android.content.Context
import android.media.MediaMetadataRetriever
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import com.murphy.library.data.model.FolderModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.SongModel
import com.murphy.library.utils.FileUtils
import java.io.File
import java.io.FileFilter
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by murphy on 2018/4/6.
 */
class MusicHelper {
    companion object {

        private val UNKNOWN = "unknown"

        fun musicFiles(dir: File?) : List<SongModel> {
            var songs = ArrayList<SongModel>()
            if (dir != null && dir.isDirectory) {
                val files = dir.listFiles(FileFilter {
                    it.isFile && FileUtils.isMusic(it)
                })

                if (files != null) {
                    for (file in files) {
                        val song = fileToMusic(file)
                        if (song != null) {
                            songs.add(song)
                        }
                    }
                }
            }
            if (songs.size > 1) {
                songs.sortWith(Comparator { left, right -> left.title.compareTo(right.title) })
            }

            return songs
        }


        fun fileToMusic(file: File) : SongModel? {
            if (file.length() == 0.toLong()) {
                return null
            }

            var metadataRetriever = MediaMetadataRetriever()
            metadataRetriever.setDataSource(file.absolutePath)

            val duration: Int
            val keyDuration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)

            if (keyDuration == null || !keyDuration.matches("\\d+".toRegex())) return null
            duration = Integer.parseInt(keyDuration)

            val title = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_TITLE, file.name)
            val displayName = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_TITLE, file.name)
            val artist = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_ARTIST, UNKNOWN)
            val album = extractMetadata(metadataRetriever, MediaMetadataRetriever.METADATA_KEY_ALBUM, UNKNOWN)
            val song = SongModel(0, title, displayName, artist, album, file.absolutePath, duration.toLong(), file.length(), 0, 0,0 )
            Log.i("MusicHelper", song.toString())
            return song
        }

        private fun extractMetadata(retriever: MediaMetadataRetriever, key: Int, defaultValue: String): String {
            var value = retriever.extractMetadata(key)
            if (TextUtils.isEmpty(value)) {
                value = defaultValue
            }
            return value
        }

        fun folderFromDir(dir: File): FolderModel {
            val folder = FolderModel(0, dir.name, dir.absolutePath, 0, "", null)
            val songs = musicFiles(dir)
            folder.songs = songs
            folder.numOfSongs = songs.size
            return folder
        }

        fun getMusicData(context: Context): ArrayList<SongModel> {
            val list = ArrayList<SongModel>()
            val cursor = context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.SIZE), null, null, MediaStore.Audio.AudioColumns.IS_MUSIC)

            if (cursor != null) {
                while (cursor.moveToNext()) {

                    val id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                    val title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                    val display_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
                    val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                    val duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    val size = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE))


                    val song = SongModel(id, title, display_name, artist, artist, path, duration.toLong(), size.toLong(), 0, 0, 0)
                    list.add(song)
                }

                cursor.close()
            }


            return list
        }

        fun getArtists(context: Context):ArrayList<ArtistModel> {
            var list = ArrayList<ArtistModel>()
            val cursor = context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.SIZE), null, null, MediaStore.Audio.AudioColumns.ARTIST)
            if (cursor != null) {
                while (cursor.moveToNext()) {

                    val id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                    val title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                    val display_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
                    val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                    val duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    val size = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE))


//                    val artistModel = ArtistModel(artist)
//                    list.add(artistModel)
                }

                cursor.close()
            }
            return list
        }
    }
}