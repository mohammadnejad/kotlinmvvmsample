package com.ms.kotlinmvvmsample.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R
import kotlinx.android.synthetic.main.fragment_home2.*

class Home2Fragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = Home2Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home2Button.setOnClickListener {
            replaceFragment(Home3Fragment.newInstance())
        }
    }

    override fun subscribeViews() {
    }
}
