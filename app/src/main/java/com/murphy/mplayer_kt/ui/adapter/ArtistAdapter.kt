package com.murphy.mplayer_kt.ui.adapter

import android.databinding.ViewDataBinding
import com.murphy.library.adapter.BaseAdapter
import com.murphy.library.adapter.BaseViewHolder
import com.murphy.library.data.model.ArtistArtModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.NewArtistModel
import com.murphy.library.rx.BaseObserver
import com.murphy.library.utils.LogUtils
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.BR
import com.murphy.mplayer_kt.databinding.ItemGridArtistBinding
import com.murphy.mplayer_kt.ui.viewmodel.ArtistViewModel

/**
 * Created by murphy on 2018/4/5.
 */
class ArtistAdapter(list: ArrayList<ArtistModel>, val viewModel: ArtistViewModel) : BaseAdapter<ArtistModel, ItemGridArtistBinding>(list) {

    override fun onBindViewHolder(holder: BaseViewHolder<ItemGridArtistBinding>, position: Int) {
        val item = mList[position]
        holder.getBinding().setVariable(BR.item, item)
        holder.getBinding().setVariable(BR.viewModel, viewModel)
        holder.getBinding().executePendingBindings()

        viewModel.handleImage(item.id, item.name, holder.getBinding().ivArtistImage)

    }

    override fun getLayoutId(type: Int): Int {
        return R.layout.item_grid_artist
    }
}