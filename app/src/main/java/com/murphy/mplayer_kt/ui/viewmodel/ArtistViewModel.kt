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
                    var small = ""
                    var medium = ""
                    var large = ""
                    var extralarge = ""

                    if (list.size > 0) {
                        small = list[0].url
                    }

                    if (list.size > 1) {
                        medium = list[1].url
                    }

                    if (list.size > 2) {
                        large = list[2].url
                    }

                    if (list.size > 3) {
                        extralarge = list[3].url
                    }

                    val artistArtModel = ArtistArtModel(small,
                            medium,
                            large,
                            extralarge)
                    ImageUtils.display(getUrl(artistArtModel), imageView)
                }
            }
        })
    }

    fun getUrl(model: ArtistArtModel): String {
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

    fun getImageUrl(name: String): Observable<NewArtistModel> {
        return respository.getArtistImageModel(name)
    }

    fun onClickListener(model: ArtistModel) {
        LogUtils.d("ArtistViewModel", model.name)
    }

}