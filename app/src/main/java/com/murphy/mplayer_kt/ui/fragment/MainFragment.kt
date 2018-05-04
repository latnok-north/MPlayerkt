package com.murphy.mplayer_kt.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.murphy.library.base.BaseFragment
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.ui.adapter.MainPagerAdapter
import com.murphy.mplayer_kt.ui.fragment.singer.SingerFragment
import com.murphy.mplayer_kt.ui.fragment.singer.SongFragment
import com.murphy.mplayer_kt.ui.fragment.special.SpecialFragment
import kotterknife.bindView

/**
 * Created by murphy on 2018/4/1.
 */
class MainFragment : BaseFragment() {


    val mViewPager: ViewPager by bindView(R.id.viewpager)
    val mTabLayout: TabLayout by bindView(R.id.tablayout)
    val mToolbar: Toolbar by bindView(R.id.toolbar)

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
        (activity as AppCompatActivity).setSupportActionBar(mToolbar)
        (activity as AppCompatActivity).supportActionBar!!.setTitle(R.string.mp_fragment_title_text)
    }

    private fun initViewPager() {
        mTitles = resources.getStringArray(R.array.mp_main_titles)
        val fragments = ArrayList<BaseFragment>()
        fragments.add(SongFragment())
        fragments.add(SingerFragment())
        fragments.add(SpecialFragment())


        val adapter = MainPagerAdapter(childFragmentManager, mTitles, fragments)
        mViewPager.adapter = adapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override val layoutId: Int
        get() = R.layout.fragment_main //To change initializer of created properties use File | Settings | File Templates.
}