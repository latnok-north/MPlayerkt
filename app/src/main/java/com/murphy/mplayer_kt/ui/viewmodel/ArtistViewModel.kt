package com.murphy.mplayer_kt.ui.viewmodel

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import com.murphy.library.base.BaseViewModel
import com.murphy.library.data.model.ArtistArtModel
import com.murphy.library.data.model.ArtistModel
import com.murphy.library.data.model.NewArtistModel
import com.murphy.library.data.respository.ArtistRespository
import com.murphy.library.rx.BaseObserver
import com.murphy.library.utils.ImageUtils
import com.murphy.library.utils.LogUtils
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.ui.adapter.ArtistAdapter
import io.reactivex.Observable
import java.util.*

class ArtistViewModel : BaseViewModel() {

    private var mList: ArrayList<ArtistModel> = ArrayList()
    var mAdapter: ArtistAdapter

    private var respository: ArtistRespository

    init {
        mAdapter = ArtistAdapter(mList, this)
        respository = ArtistRespository()
    }


    fun loadData(context: Context) {
        respository.getAllArtist(context).subscribe(object : BaseObserver<ArrayList<ArtistModel>>() {
            override fun onSuccess(t: ArrayList<ArtistModel>) {
                mList.addAll(t)
                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(e: Throwable) {
                mAdapter.notifyDataSetChanged()
            }

        })
    }

    fun handleImage(id: Long, name: String, imageView: ImageView) {

        getImageUrl(name).subscribe(object : BaseObserver<NewArtistModel>() {
            override fun onFailure(e: Throwable) {
            }

            override fun onSuccess(t: NewArtistModel) {
                LogUtils.d("ArtistAdapter", t.toString())
                if (t.artist != null) {
                    val list = t.artist.image
                    val small = getIndexUrl(list, 0)
                    val medium = getIndexUrl(list, 1)
                    val large = getIndexUrl(list, 2)
                    val extraLarge = getIndexUrl(list, 3)

                    val artistArtModel = ArtistArtModel(small,
                            medium,
                            large,
                            extraLarge)

                    ImageUtils.display(getUrl(artistArtModel), imageView, R.attr.default_artist_drawable)
                }
            }
        })
    }

    private fun getIndexUrl(list: List<NewArtistModel.ArtistBeanX.ImageBeanX>, index: Int): String {
        if (list.size > index) {
            return list[index].url
        }
        return ""
    }

    private fun getUrl(model: ArtistArtModel): String {
        if (!TextUtils.isEmpty(model.extralarge)) {
            return model.extralarge
        }

        if (!TextUtils.isEmpty(model.large)) {
            return model.large
        }

        if (!TextUtils.isEmpty(model.medium)) {
            return model.medium
        }

        if (!TextUtils.isEmpty(model.small)) {
            return model.small
        }

        return ""
    }

    private fun getImageUrl(name: String): Observable<NewArtistModel> {
        return respository.getArtistImageModel(name)
    }

    fun onClickListener(model: ArtistModel) {
        LogUtils.d("ArtistViewModel", model.name)
    }

}