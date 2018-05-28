package com.ms.kotlinmvvmsample.location


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R
import kotlinx.android.synthetic.main.fragment_location1.*

class Location1Fragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = Location1Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        location1Button.setOnClickListener {
            replaceFragment(Location2Fragment.newInstance())
        }
    }

    override fun subscribeViews() {
    }
}
