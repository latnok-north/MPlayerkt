package com.murphy.mplayer_kt.ui.adapter

import android.content.ContentUris
import android.net.Uri
import com.murphy.library.adapter.BaseAdapter
import com.murphy.library.adapter.BaseViewHolder
import com.murphy.library.data.model.SongModel
import com.murphy.library.utils.ImageUtils
import com.murphy.mplayer_kt.BR
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.databinding.ItemPlaySongBinding
import com.murphy.mplayer_kt.ui.viewmodel.SongViewModel

/**
 * Created by murphy on 2018/4/7.
 */
class SongAdapter(list: ArrayList<SongModel>, viewModel : SongViewModel) : BaseAdapter<SongModel, ItemPlaySongBinding>(list){
    override fun getLayoutId(type: Int): Int {
        return   R.layout.item_play_song
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemPlaySongBinding>, position: Int, type: Int) {
        val item = mList[position]
        holder.getBinding().setVariable(BR.item, item)

        val uri = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), item.albumId)
        ImageUtils.display(uri, holder.getBinding().ivSingerImg, R.attr.default_artist_drawable)
        holder.getBinding().executePendingBindings()
    }

//    override fun isHeaderEnabled(): Boolean {
//        return true
//    }
//
//    override fun createHeaderView(): View? {
//        return LayoutInflater.from(context).inflate(R.layout.item_play_shuffle, null)
//    }
//
//    override fun createView(context: Context, viewType: Int): SongItemView {
//        return SongItemView(context)
//    }


}