package com.murphy.mplayer_kt.ui.adapter.itemview

import android.content.Context
import android.support.design.widget.NavigationView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.ButterKnife
import com.murphy.library.adapter.IAdapterView
import com.murphy.library.data.model.SingerModel
import com.murphy.mplayer_kt.R
import kotterknife.bindView

/**
 * Created by murphy on 2018/4/5.
 */
class SingerItemView(context: Context) : IAdapterView<SingerModel>, RelativeLayout(context) {

    val tvSingerTitle: TextView by bindView(R.id.tvSingerTitle)
    val ivSingerImg: ImageView by bindView(R.id.ivSingerImg)
    val ivSingerMenu: ImageView by bindView(R.id.ivSingerMenu)

    override fun bind(item: SingerModel?, position: Int) {
        tvSingerTitle.text = item?.title ?: ""
    }

    init {
        View.inflate(context, R.layout.item_play_song, this)
//        ButterKnife.bind(this)
//        tvSingerTitle = findViewById(R.id.tvSingerTitle)
    }
}