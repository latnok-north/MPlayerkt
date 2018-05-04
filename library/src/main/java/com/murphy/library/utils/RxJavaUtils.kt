package com.murphy.library.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by murphy on 2018/4/7.
 */
class RxJavaUtils {
    companion object {
        fun <T> setThread(): ObservableTransformer<T, T> {
            return ObservableTransformer { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }
    }
}