package com.murphy.mplayer_kt.ui.adapter

import android.content.Context
import com.murphy.library.adapter.AbstractSummaryAdapter
import com.murphy.library.data.model.ArtistModel
import com.murphy.mplayer_kt.ui.adapter.itemview.ArtistItemView

/**
 * Created by murphy on 2018/4/5.
 */
class ArtistAdapter(context: Context, list: ArrayList<ArtistModel>) : AbstractSummaryAdapter<ArtistModel, ArtistItemView>(context, list){

    override fun createView(context: Context, viewType: Int): ArtistItemView {
        return ArtistItemView(context)
    }
}