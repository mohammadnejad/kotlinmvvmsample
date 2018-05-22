package com.ms.kotlinmvvmsample.location


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R

class Location2Fragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = Location2Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location2, container, false)
    }
}
