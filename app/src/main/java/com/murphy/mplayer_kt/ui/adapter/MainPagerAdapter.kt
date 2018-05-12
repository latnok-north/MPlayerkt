package com.murphy.mplayer_kt.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.murphy.library.base.BaseFragment

/**
 * Created by murphy on 2018/4/5.
 */
class MainPagerAdapter(fm: FragmentManager, var mTitles: Array<String>, var mFragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }

    override fun getCount(): Int {
        return mTitles.size
    }
}