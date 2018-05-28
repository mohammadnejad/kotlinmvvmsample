package com.ms.kotlinmvvmsample.setting


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R
import kotlinx.android.synthetic.main.fragment_setting1.*

class Setting1Fragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = Setting1Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setting1Button.setOnClickListener {
            replaceFragment(Setting2Fragment.newInstance())
        }
    }

    override fun subscribeViews() {
    }
}
