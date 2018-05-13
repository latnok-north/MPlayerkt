package com.murphy.library.net

import com.murphy.library.net.interceptor.CacheInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient() {
    companion object {
        private val BASE_URL: String = ""
        private val mClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitClient()
        }

        fun getInstance(): RetrofitClient {
            return mClient
        }
    }

    val DEFAULT_READ_TIMEOUT_MILLIS : Long = 15 * 1000
    val DEFAULT_WRITE_TIMEOUT_MILLIS : Long = 20 * 1000
    val DEFAULT_CONNECT_TIMEOUT_MILLIS : Long = 20 * 1000

    private var mHttpClient: OkHttpClient
    private var mRetrofit: Retrofit

    init {

        mHttpClient = OkHttpClient
                .Builder()
                .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .addInterceptor(CacheInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        mRetrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mHttpClient)
                .build()
    }

    fun <T> create(clazz: Class<T>): T {
        return mRetrofit.create(clazz)
    }

}