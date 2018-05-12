package com.murphy.library.adapter

/**
 * Created by murphy on 2018/4/1.
 */
interface IAdapterView<T> {
    fun bind(item: T?, position: Int)
//    fun getLayoutResId(): Int
}