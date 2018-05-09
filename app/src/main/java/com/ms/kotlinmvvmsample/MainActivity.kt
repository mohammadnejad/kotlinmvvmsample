package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.core.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.core.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(R.id.mainToolbar) {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        replaceFragmentInActivity(HomeFragment.newInstance(), R.id.frameLayout)
    }
}
