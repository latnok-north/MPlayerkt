package com.murphy.library.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.LibraryGlideModule
import com.bumptech.glide.load.model.GlideUrl
import com.murphy.library.glide.okhttp.OkHttpUrlLoaderFactory
import java.io.InputStream


@GlideModule
class OkHttpLibraryGlideModule : LibraryGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoaderFactory.factory())
    }
}