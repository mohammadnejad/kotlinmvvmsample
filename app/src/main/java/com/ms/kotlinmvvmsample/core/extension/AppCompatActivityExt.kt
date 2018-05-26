package com.ms.kotlinmvvmsample.core.extension

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.ms.kotlinmvvmsample.ViewModelFactory

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/17/18
 */

/**
 * Various extensions for AppCompatActivity
 */

fun AppCompatActivity.setActionBar(@IdRes toolBarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolBarId))
    supportActionBar?.run {
        action()
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commitAllowingStateLoss()
}

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int, stackName: String? = null, tagName: String? = null, hasBackStack: Boolean = false) {
    if (hasBackStack) {
        supportFragmentManager.transact {
            replace(frameId, fragment, tagName)
            addToBackStack(stackName)
        }
    } else {
        supportFragmentManager.transact {
            replace(frameId, fragment, tagName)
        }
    }
}

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int, fragmentManager: FragmentManager,
                                                stackName: String? = null, tagName: String? = null, hasBackStack: Boolean = false) {
    if (hasBackStack) {
        fragmentManager.transact {
            replace(frameId, fragment, tagName)
            addToBackStack(stackName)
        }
    } else {
        fragmentManager.transact {
            replace(frameId, fragment, tagName)
        }
    }
}

//fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
//        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(activity!!.application)).get(viewModelClass)