package com.murphy.mplayer_kt.ui.adapter

import android.content.Context
import com.murphy.library.adapter.AbstractSummaryAdapter
import com.murphy.library.data.model.SingerModel
import com.murphy.mplayer_kt.ui.adapter.itemview.SingerItemView

/**
 * Created by murphy on 2018/4/5.
 */
class SingerAdapter(context: Context, list: ArrayList<SingerModel>) : AbstractSummaryAdapter<SingerModel, SingerItemView>(context, list){

    override fun createView(context: Context, viewType: Int): SingerItemView {
        return SingerItemView(context)
    }
}