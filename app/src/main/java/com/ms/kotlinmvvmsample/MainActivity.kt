package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.core.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.core.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment
import com.ms.kotlinmvvmsample.location.Location1Fragment
import com.ms.kotlinmvvmsample.setting.Setting1Fragment
import com.ms.kotlinmvvmsample.view.bottomnavigation.events.OnSelectedItemChangeListener
import kotlinx.android.synthetic.main.activity_main_content.*

class MainActivity : AppCompatActivity(), IFragmentCallBack, OnSelectedItemChangeListener {

    private var selectedTabItemPos = 0
    private var horizontalStack: MutableList<Int> = arrayListOf()

    private val homeFragment: HomeFragment by lazy {
        HomeFragment.newInstance()
    }

    private val locationFragment: Location1Fragment by lazy {
        Location1Fragment.newInstance()
    }

    private val settingFragment: Setting1Fragment by lazy {
        Setting1Fragment.newInstance()
    }

    companion object {
        const val TAB_HOME_POSITION: Int = 0
        const val TAB_LOCATION_POSITION: Int = 1
        const val TAB_SETTING_POSITION: Int = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(R.id.mainToolbar) {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnSelectedItemChangeListener(this)

        tabHome.itemPosition = TAB_HOME_POSITION
        tabSetting.itemPosition = TAB_SETTING_POSITION
        tabLocation.itemPosition = TAB_LOCATION_POSITION
    }

    override fun onSelectedItemChanged(tabViewId: Int) {
        when (tabViewId) {
            R.id.tabHome -> {
                addToHorizontalBackStack(homeFragment, tabHome.itemPosition)
            }
            R.id.tabLocation -> {
                addToHorizontalBackStack(locationFragment, tabLocation.itemPosition)
            }
            R.id.tabSetting -> {
                addToHorizontalBackStack(settingFragment, tabSetting.itemPosition)
            }
        }
    }

    // Called from inside MainActivity for root stack
    private fun addToHorizontalBackStack(fragment: BaseFragment, tabId: Int) {
        selectedTabItemPos = tabId

        horizontalStack.remove(tabId)
        horizontalStack.add(tabId)

        replaceFragmentInActivity(fragment, R.id.frameLayout, hasBackStack = true)
    }

    // Called from outside MainActivity for child stack
    override fun replaceFragment(fragment: BaseFragment) {
        when (selectedTabItemPos) {
            TAB_HOME_POSITION -> replaceFragmentInActivity(fragment, R.id.frameLayout, homeFragment.childFragmentManager, hasBackStack = true)
            TAB_LOCATION_POSITION -> replaceFragmentInActivity(fragment, R.id.frameLayout, locationFragment.childFragmentManager, hasBackStack = true)
            TAB_SETTING_POSITION -> replaceFragmentInActivity(fragment, R.id.frameLayout, settingFragment.childFragmentManager, hasBackStack = true)
        }
    }

    override fun onBackPressed() {
        val childFragmentManager = when (selectedTabItemPos) {
            TAB_HOME_POSITION -> homeFragment.childFragmentManager
            TAB_LOCATION_POSITION -> locationFragment.childFragmentManager
            TAB_SETTING_POSITION -> settingFragment.childFragmentManager

            else -> null
        }

        if (childFragmentManager == null) {
            supportFinishAfterTransition()
            return
        }

        if (childFragmentManager.backStackEntryCount >= 1) {
            childFragmentManager.popBackStack()
        } else {
            if (horizontalStack.size > 1) {
                supportFragmentManager.popBackStack()
                horizontalStack.removeAt(horizontalStack.size - 1)
                bottomNavigation.selectedItem = horizontalStack[horizontalStack.size - 1]
            } else {
                supportFinishAfterTransition()
            }
        }
    }
}
