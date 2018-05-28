package com.ms.kotlinmvvmsample.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R
import com.ms.kotlinmvvmsample.core.extension.obtainViewModel
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var rootView: View? = null

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = obtainViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false)
        }

        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getCurrentWeather("London")
    }

    override fun subscribeViews() {
        val weather = Observer<LocalWeather> {
            degreeTextView.text = it?.main?.temp.toString()
        }

        // add to view model observer
        homeViewModel.mWeather.observe(this, weather)
    }

    private fun obtainViewModel(): HomeViewModel = obtainViewModel(HomeViewModel::class.java)

}
