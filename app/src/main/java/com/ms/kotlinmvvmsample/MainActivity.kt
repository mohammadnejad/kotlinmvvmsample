package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.core.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.core.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment
import com.ms.kotlinmvvmsample.location.Location1Fragment
import com.ms.kotlinmvvmsample.setting.Setting1Fragment
import com.ms.kotlinmvvmsample.view.bottomnavigation.events.OnSelectedItemChangeListener
import kotlinx.android.synthetic.main.activity_main_content.*

class MainActivity : AppCompatActivity(), IFragmentCallBack, OnSelectedItemChangeListener {

    private var onTabItemSelected = 0
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
        const val POP_FLAG: Int = 0
        const val ROOT_STACK: String = "rootStack"
        const val HOME_STACK: Int = 0
        const val LOCATION_STACK: Int = 1
        const val SETTING_STACK: Int = 2
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

        tabHome.itemId = HOME_STACK
        tabSetting.itemId = SETTING_STACK
        tabLocation.itemId = LOCATION_STACK
    }

    override fun onSelectedItemChanged(tabId: Int) {
        when (tabId) {
            R.id.tabHome -> {
                addToHorizontalBackStack(homeFragment, tabHome.itemId)
                onTabItemSelected = tabHome.itemId
            }
            R.id.tabLocation -> {
                addToHorizontalBackStack(locationFragment, tabLocation.itemId)
                onTabItemSelected = tabLocation.itemId
            }
            R.id.tabSetting -> {
                addToHorizontalBackStack(settingFragment, tabSetting.itemId)
                onTabItemSelected = tabSetting.itemId
            }
        }
    }

    private fun addToHorizontalBackStack(fragment: BaseFragment, tabId: Int) {
        horizontalStack.remove(tabId)
        horizontalStack.add(tabId)
        pushFragmentToHorizontalStack(fragment, ROOT_STACK, tabId.toString())
    }

    override fun replaceFragment(fragment: BaseFragment) {
//        with(fragment) {
//            when {
//                (fragment) is HomeFragment -> replaceFragment(fragment, HOME_STACK)
//                (fragment) is Home2Fragment -> replaceFragment(fragment, HOME_STACK)
//                (fragment) is Home3Fragment -> replaceFragment(fragment, HOME_STACK)
//
//                (fragment) is Setting1Fragment -> replaceFragment(fragment, SETTING_STACK)
//                (fragment) is Setting2Fragment -> replaceFragment(fragment, SETTING_STACK)
//                (fragment) is Setting3Fragment -> replaceFragment(fragment, SETTING_STACK)
//
//                (fragment) is Location1Fragment -> replaceFragment(fragment, LOCATION_STACK)
//                (fragment) is Location2Fragment -> replaceFragment(fragment, LOCATION_STACK)
//                (fragment) is Location3Fragment -> replaceFragment(fragment, LOCATION_STACK)
//
//                else -> throw Exception("not found your fragment")
//            }
//        }
    }

    private fun pushFragmentToHorizontalStack(fragment: Fragment, stackName: String, tagName: String) {
        replaceFragmentInActivity(fragment, R.id.frameLayout, stackName, tagName)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (horizontalStack.size > 1) {
            supportFragmentManager.popBackStack(ROOT_STACK, POP_FLAG)
            horizontalStack.removeAt(horizontalStack.size - 1)
            bottomNavigation.selectedItem = horizontalStack[horizontalStack.size - 1]
        } else {
            supportFinishAfterTransition()
        }
    }
}
