package com.murphy.library.net

class ApiConstants {

    companion object {
        const val getArtistInfo = "?method=artist.getinfo&api_key=fdb3a51437d4281d4d64964d333531d4&format=json"

        const val searchLyric = "search?ver=1&man=yes&client=pc"
        const val getRawLyric = "download?ver=1&client=pc&fmt=lrc&charset=utf8"
    }
}