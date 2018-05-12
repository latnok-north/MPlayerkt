package com.murphy.mplayer_kt.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.murphy.library.base.BaseFragment
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.databinding.FragmentMainBinding
import com.murphy.mplayer_kt.ui.adapter.MainPagerAdapter
import com.murphy.mplayer_kt.ui.fragment.artist.ArtistFragment
import com.murphy.mplayer_kt.ui.fragment.artist.SongFragment
import com.murphy.mplayer_kt.ui.fragment.special.SpecialFragment
import com.murphy.mplayer_kt.ui.viewmodel.MainViewModel

/**
 * Created by murphy on 2018/4/1.
 */
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override fun initViewModel(): MainViewModel {
        return MainViewModel()
    }

    lateinit var mTitles: Array<String>

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onBaseViewCreated(savedInstanceState: Bundle?) {
        init()
    }

    private fun init() {
        initToolbar()
        initViewPager()
    }

    fun initToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(mBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setTitle(R.string.mp_fragment_title_text)
    }

    private fun initViewPager() {
        mTitles = resources.getStringArray(R.array.mp_main_titles)
        val fragments = ArrayList<Fragment>()
        fragments.add(SongFragment())
        fragments.add(ArtistFragment())
        fragments.add(SpecialFragment())


        val adapter = MainPagerAdapter(childFragmentManager, mTitles, fragments)
        mBinding.viewpager.adapter = adapter
        mBinding.tablayout.setupWithViewPager(mBinding.viewpager)
    }

    override val layoutId: Int
        get() = R.layout.fragment_main //To change initializer of created properties use File | Settings | File Templates.
}