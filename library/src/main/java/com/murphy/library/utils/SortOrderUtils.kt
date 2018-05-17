package com.murphy.library.utils

import android.provider.MediaStore

class SortOrderUtils {

    interface ArtistSortOrder {
        companion object {
            /* Artist sort order A-Z */
            val ARTIST_A_Z = MediaStore.Audio.Artists.DEFAULT_SORT_ORDER

            /* Artist sort order Z-A */
            val ARTIST_Z_A = "$ARTIST_A_Z DESC"

            /* Artist sort order number of songs */
            val ARTIST_NUMBER_OF_SONGS = MediaStore.Audio.Artists.NUMBER_OF_TRACKS + " DESC"

            /* Artist sort order number of albums */
            val ARTIST_NUMBER_OF_ALBUMS = MediaStore.Audio.Artists.NUMBER_OF_ALBUMS + " DESC"
        }
    }

    /**
     * Album sort order entries.
     */
    interface AlbumSortOrder {
        companion object {
            /* Album sort order A-Z */
            val ALBUM_A_Z = MediaStore.Audio.Albums.DEFAULT_SORT_ORDER

            /* Album sort order Z-A */
            val ALBUM_Z_A = "$ALBUM_A_Z DESC"

            /* Album sort order songs */
            val ALBUM_NUMBER_OF_SONGS = MediaStore.Audio.Albums.NUMBER_OF_SONGS + " DESC"
        }

    }

    /**
     * Song sort order entries.
     */
    interface SongSortOrder {
        companion object {
            /* Song sort order A-Z */
            val SONG_A_Z = MediaStore.Audio.Media.DEFAULT_SORT_ORDER

            /* Song sort order Z-A */
            val SONG_Z_A = "$SONG_A_Z DESC"

            /* Song sort order artist */
            val SONG_ARTIST = MediaStore.Audio.Media.ARTIST

            /* Song sort order album */
            val SONG_ALBUM = MediaStore.Audio.Media.ALBUM

            /* Song sort order duration */
            val SONG_DURATION = MediaStore.Audio.Media.DURATION + " DESC"

            /* Song sort order date */
            val SONG_DATE = MediaStore.Audio.Media.DATE_ADDED + " DESC"

            /* Song sort order filename */
            val SONG_FILENAME = MediaStore.Audio.Media.DATA
        }
    }

    /**
     * Album song sort order entries.
     */
    interface AlbumSongSortOrder {
        companion object {
            /* Album song sort order A-Z */
            val SONG_A_Z = MediaStore.Audio.Media.DEFAULT_SORT_ORDER

            /* Album song sort order Z-A */
            val SONG_Z_A = "$SONG_A_Z DESC"

            /* Album song sort order track list */
            val SONG_TRACK_LIST = (MediaStore.Audio.Media.TRACK + ", "
                    + MediaStore.Audio.Media.DEFAULT_SORT_ORDER)

            /* Album song sort order duration */
            val SONG_DURATION = SongSortOrder.SONG_DURATION

            /* Album Song sort order year */
            val SONG_YEAR = MediaStore.Audio.Media.YEAR + " DESC"
        }

    }

    /**
     * Artist song sort order entries.
     */
    interface ArtistSongSortOrder {
        companion object {
            /* Artist song sort order A-Z */
            val SONG_A_Z = MediaStore.Audio.Media.DEFAULT_SORT_ORDER
        }

    }
}