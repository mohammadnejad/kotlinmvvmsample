package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.core.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.core.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment
import com.ms.kotlinmvvmsample.location.LocationFragment
import com.ms.kotlinmvvmsample.setting.SettingFragment
import kotlinx.android.synthetic.main.activity_main_content.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(R.id.mainToolbar) {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        bottomNavigation.setOnSelectedItemChangeListener {
            when (it) {
                R.id.tabHome -> replaceFragment(HomeFragment.newInstance())
                R.id.tabSetting -> replaceFragment(SettingFragment.newInstance())
                R.id.tabLocation -> replaceFragment(LocationFragment.newInstance())
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        replaceFragmentInActivity(fragment, R.id.frameLayout)
    }
}
