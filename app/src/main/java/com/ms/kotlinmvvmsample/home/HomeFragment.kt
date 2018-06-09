package com.ms.kotlinmvvmsample.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ms.kotlinmvvmsample.BaseFragment
import com.ms.kotlinmvvmsample.R
import com.ms.kotlinmvvmsample.core.extension.convertKelvinToCelsius
import com.ms.kotlinmvvmsample.core.extension.getHourFromMillisecond
import com.ms.kotlinmvvmsample.core.extension.obtainViewModel
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
        return rootView ?: inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getCurrentWeather("Tehran")
        homeViewModel.getForecast("Tehran")
    }

    override fun subscribeViews() {
        // add to view model observer
        homeViewModel.mWeather.observe(this, Observer {
            cityNameTextView.text = String.format(resources.getString(R.string.city_name), it?.name, it?.sys?.country).toUpperCase()
            degreeTextView.text = String.format(resources.getString(R.string.degree_text), convertKelvinToCelsius(it?.main?.temp?.toDouble()).toInt().toString())
            windFlowTextView.text = it?.wind?.deg?.toInt().toString()
            preceptionTextView.text = it?.main?.pressure?.toString()
            humidityTextView.text = it?.main?.humidity?.toString()
        })

        homeViewModel.mForecast.observe(this, Observer {
            it?.apply {
                if (it.size >= 5) {
                    time1TextView.text = getHourFromMillisecond(it[0].dt * 1000)
                    time1StatusTextView.text = it[0].main

                    time2TextView.text = getHourFromMillisecond(it[1].dt * 1000)
                    time2StatusTextView.text = it[1].main

                    time3TextView.text = getHourFromMillisecond(it[2].dt * 1000)
                    time3StatusTextView.text = it[2].main

                    time4TextView.text = getHourFromMillisecond(it[3].dt * 1000)
                    time4StatusTextView.text = it[3].main

                    time5TextView.text = getHourFromMillisecond(it[4].dt * 1000)
                    time5StatusTextView.text = it[4].main
                }
            }
        })
    }

    private fun obtainViewModel(): HomeViewModel = obtainViewModel(HomeViewModel::class.java)
}
