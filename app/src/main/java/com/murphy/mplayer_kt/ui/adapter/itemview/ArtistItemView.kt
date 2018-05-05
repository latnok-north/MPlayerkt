package com.murphy.mplayer_kt.ui.adapter.itemview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.murphy.library.adapter.IAdapterView
import com.murphy.library.data.model.ArtistModel
import com.murphy.mplayer_kt.R
import kotterknife.bindView

/**
 * Created by murphy on 2018/4/5.
 */
class ArtistItemView(context: Context) : IAdapterView<ArtistModel>, RelativeLayout(context) {

    val tvArtistName: TextView by bindView(R.id.tvArtistName)
    val ivArtistImage: ImageView by bindView(R.id.ivArtistImage)
    val ivArtistMenu: ImageView by bindView(R.id.ivArtistMenu)

    override fun bind(item: ArtistModel?, position: Int) {
        tvArtistName.text = item?.title ?: ""
    }

    init {
        View.inflate(context, R.layout.item_grid_artist, this)
    }
}