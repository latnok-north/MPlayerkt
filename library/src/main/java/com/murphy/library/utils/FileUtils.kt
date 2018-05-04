package com.murphy.library.utils

import java.io.File

/**
 * Created by murphy on 2018/4/7.
 */
class FileUtils {
    companion object {
        fun isMusic(file: File): Boolean {
            val REGEX = "(.*/)*.+\\.(mp3|m4a|ogg|wav|aac)$"
            return file.name.matches(REGEX.toRegex())
        }
    }
}