package com.murphy.library.glide.okhttp

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.murphy.library.net.RetrofitClient
import okhttp3.OkHttpClient
import java.io.InputStream

class OkHttpUrlLoaderFactory(val client: OkHttpClient) : ModelLoaderFactory<GlideUrl, InputStream> {

    companion object {
        fun factory() :  OkHttpUrlLoaderFactory {
            return OkHttpUrlLoaderFactory(RetrofitClient.getInstance().getOkHttpClient())
        }
    }

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<GlideUrl, InputStream> {
        return OkHttpUrlLoader(client)
    }

    override fun teardown() {

    }
}