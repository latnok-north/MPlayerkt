package com.murphy.mplayer_kt.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.murphy.library.adapter.AbstractSummaryAdapter
import com.murphy.library.adapter.IAdapterView
import com.murphy.library.data.model.SongModel
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.ui.adapter.itemview.SongItemView

/**
 * Created by murphy on 2018/4/7.
 */
class SongAdapter(private val context: Context, list: ArrayList<SongModel>) : AbstractSummaryAdapter<SongModel, SongItemView>(context, list){

    override fun isHeaderEnabled(): Boolean {
        return true
    }

    override fun createHeaderView(): View? {
        return LayoutInflater.from(context).inflate(R.layout.item_play_shuffle, null)
    }

    override fun createView(context: Context, viewType: Int): SongItemView {
        return SongItemView(context)
    }


}