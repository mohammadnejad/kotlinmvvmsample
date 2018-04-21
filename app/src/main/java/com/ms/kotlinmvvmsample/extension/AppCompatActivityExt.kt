package com.ms.kotlinmvvmsample.extension

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
    }.commit()
}

fun AppCompatActivity.addFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        add(frameId, fragment)
    }
}

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)