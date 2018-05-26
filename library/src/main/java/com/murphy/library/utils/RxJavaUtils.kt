package com.murphy.library.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by murphy on 2018/4/7.
 */
class RxJavaUtils {
    companion object {
        fun <T> transformerForObservable(): ObservableTransformer<T, T> {
            return ObservableTransformer { upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }

        fun <T> transformerForFlowable(): FlowableTransformer<T, T> {
            return FlowableTransformer {
                    it -> it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            }
        }

        fun <T> transformerForSinger() : SingleTransformer<T, T> {
            return SingleTransformer { it -> it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }


    }
}