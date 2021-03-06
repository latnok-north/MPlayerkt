package com.murphy.mplayer_kt.ui.adapter.itemview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.murphy.library.adapter.IAdapterView
import com.murphy.library.data.model.SongModel
import com.murphy.mplayer_kt.R

/**
 * Created by murphy on 2018/4/7.
 */
class SongItemView(context: Context) : IAdapterView<SongModel>, RelativeLayout(context) {

    var tvSingerTitle: TextView
    var ivSingerImg: ImageView
    var ivSingerMenu: ImageView

    override fun bind(item: SongModel?, position: Int) {
        tvSingerTitle.text = item?.title ?: ""
    }

    init {
        View.inflate(context, R.layout.item_play_song, this)
        tvSingerTitle = findViewById(R.id.tvSingerTitle)
        ivSingerImg = findViewById(R.id.ivSingerImg)
        ivSingerMenu = findViewById(R.id.ivSingerMenu)
    }

}