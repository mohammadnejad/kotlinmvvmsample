package com.ms.kotlinmvvmsample


import android.os.Bundle
import android.support.v4.app.Fragment

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun replaceFragment(fragment: Fragment) {
        ((activity) as MainActivity).replaceFragment(fragment)
    }
}
