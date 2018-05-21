package com.murphy.mplayer_kt.ui.fragment.special

import android.support.v7.widget.RecyclerView
import com.murphy.library.data.model.ArtistModel
import com.murphy.mplayer_kt.ui.adapter.ArtistAdapter
import com.murphy.mplayer_kt.ui.fragment.BaseItemListFragment
import com.murphy.mplayer_kt.ui.viewmodel.SpecialViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class SpecialFragment : BaseItemListFragment<SpecialViewModel>() {
    override fun initViewModel(): SpecialViewModel {
        return SpecialViewModel()
    }

    lateinit var mAdapter: ArtistAdapter
    lateinit var mList: ArrayList<ArtistModel>


    override fun generateAdapter(): RecyclerView.Adapter<*> {
        return mAdapter
    }

    override fun onBaseItemViewCreated() {
        mList = ArrayList()
        for (i in 0..19) {
//            mList.add(ArtistModel("第" + i + "首"))
        }
//        mAdapter = ArtistAdapter(activity!!, mList)

//        viewModel?.getValue()?.observe(this, Observer { t ->
//            if (t != null) {
//                LogUtils.d("SpecialFragment_vvv", t)
//            }
//        })
    }
}