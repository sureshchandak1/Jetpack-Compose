package com.material.androidpro.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    protected open fun getCurrentFragment(): Fragment? {
        /*val manager: FragmentManager = supportFragmentManager
        return manager.findFragmentById(R.id.fragmentContainer)*/
        return null
    }

    /*protected fun addFragment(addFragment: Fragment) {
        Thread(Runnable {
            var currentFragmentName = ""
            val currentFragment = getCurrentFragment()
            if (currentFragment != null) {
                currentFragmentName = currentFragment.javaClass.name
            }
            if (addFragment.javaClass.name == currentFragmentName) {
                return@Runnable
            }
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.fragmentContainer, addFragment)
            transaction.commit()
        }).start()
    }*/

    /*protected fun replaceFragment(addFragment: Fragment) {
        Thread(Runnable {
            var currentFragmentName = ""
            val currentFragment = getCurrentFragment()
            if (currentFragment != null) {
                currentFragmentName = currentFragment.javaClass.name
            }
            if (addFragment.javaClass.name == currentFragmentName) {
                return@Runnable
            }
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, addFragment)
            transaction.commit()
        }).start()
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val fragment = getCurrentFragment()
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
