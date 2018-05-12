package com.murphy.mplayer_kt.ui.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import com.murphy.library.base.BaseActivity
import com.murphy.library.widget.SlidingUpPanelLayout.SlidingUpPanelLayout
import com.murphy.mplayer_kt.R
import com.murphy.mplayer_kt.databinding.ActivityMainBinding
import com.murphy.mplayer_kt.ui.fragment.MainFragment
import com.murphy.mplayer_kt.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.include_main_content.view.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun initViewModel(): MainViewModel {
        return MainViewModel()
    }

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
                    mBinding.mainContent?.slidingLayout?.panelState === SlidingUpPanelLayout.PanelState.EXPANDED -> mBinding.mainContent?.slidingLayout?.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
                    isNavigatingMain() -> mBinding.drawerLayout.openDrawer(GravityCompat.START)
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
