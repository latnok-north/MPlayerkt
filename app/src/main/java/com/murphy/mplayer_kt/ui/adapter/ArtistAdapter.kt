package com.murphy.mplayer_kt.ui.adapter

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.murphy.library.adapter.BaseAdapter
import com.murphy.library.adapter.BaseViewHolder
import com.murphy.library.data.model.ArtistModel
import com.murphy.mplayer_kt.R

/**
 * Created by murphy on 2018/4/5.
 */
class ArtistAdapter(context: Context, list: ArrayList<ArtistModel>) : BaseAdapter<ArtistModel>(context, list){

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var baseViewHolder = holder as? BaseViewHolder<ViewDataBinding>
//        baseViewHolder?.getBinding()?.setVariable()
    }

    override fun getLayoutId(type: Int): Int {
        return R.layout.item_grid_artist
    }
}