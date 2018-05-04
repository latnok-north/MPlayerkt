package com.murphy.mplayer_kt.ui.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import com.murphy.library.base.BaseActivity
import com.murphy.library.widget.SlidingUpPanelLayout.SlidingUpPanelLayout
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.ui.fragment.MainFragment
import kotterknife.bindView

class MainActivity : BaseActivity() {

    val mDrawerLayout: DrawerLayout by bindView(R.id.drawerLayout)
    val mNavigationView: NavigationView by bindView(R.id.navView)
    val mSlidingLayout: SlidingUpPanelLayout by bindView(R.id.slidingLayout)


    override fun onBaseCreate(savedInstanceState: Bundle?) {
        navigateLibrary()
    }

    override val layoutId: Int
        get() = R.layout.activity_main


    private fun navigateLibrary() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, MainFragment.newInstance()).commitAllowingStateLoss()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                when {
                    mSlidingLayout.panelState === SlidingUpPanelLayout.PanelState.EXPANDED -> mSlidingLayout.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
                    isNavigatingMain() -> mDrawerLayout.openDrawer(GravityCompat.START)
                    else -> super.onBackPressed()
                }
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


    private fun isNavigatingMain(): Boolean {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        return currentFragment is MainFragment
    }

}
