package com.ms.kotlinmvvmsample


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment : Fragment() {

    private var mFragmentListener: IFragmentCallBack? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeViews()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mFragmentListener = ((context) as IFragmentCallBack)
    }

    override fun onDetach() {
        super.onDetach()
        mFragmentListener = null
    }

    fun replaceFragment(fragment: BaseFragment) {
        mFragmentListener?.replaceFragment(fragment)
    }

    abstract fun subscribeViews()
}
