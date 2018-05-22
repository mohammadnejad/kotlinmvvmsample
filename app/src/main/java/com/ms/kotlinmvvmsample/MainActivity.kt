package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.core.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.core.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment
import com.ms.kotlinmvvmsample.location.Location1Fragment
import com.ms.kotlinmvvmsample.setting.Setting1Fragment
import kotlinx.android.synthetic.main.activity_main_content.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val STACK_1: String = "stack1"
        const val STACK_2: String = "stack2"
        private var INSTANCE: MainActivity? = null

        fun getInstance() =
                INSTANCE ?: synchronized(MainActivity::class.java) {
                    INSTANCE ?: MainActivity()
                }.also { INSTANCE = it }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(R.id.mainToolbar) {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        bottomNavigation.setOnSelectedItemChangeListener {
            when (it) {
                R.id.tabHome -> replaceFragment(HomeFragment.newInstance(), STACK_1)
                R.id.tabSetting -> replaceFragment(Setting1Fragment.newInstance(), STACK_1)
                R.id.tabLocation -> replaceFragment(Location1Fragment.newInstance(), STACK_1)
            }
        }

    }

    fun replaceFragment(fragment: Fragment) {
        replaceFragmentInActivity(fragment, R.id.frameLayout)
    }

    private fun replaceFragment(fragment: Fragment, stackName: String? = null) {
        replaceFragmentInActivity(fragment, R.id.frameLayout, stackName)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount >= 1) {
            supportFragmentManager.popBackStack(STACK_1, 0)
        } else {
            supportFinishAfterTransition()
        }
    }
}
