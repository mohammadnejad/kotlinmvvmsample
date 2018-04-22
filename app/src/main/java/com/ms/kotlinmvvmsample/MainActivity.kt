package com.ms.kotlinmvvmsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.extension.replaceFragmentInActivity
import com.ms.kotlinmvvmsample.extension.setActionBar
import com.ms.kotlinmvvmsample.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

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
