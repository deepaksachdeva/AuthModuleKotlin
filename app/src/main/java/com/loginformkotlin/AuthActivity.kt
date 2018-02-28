package com.loginformkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment

class AuthActivity : AppCompatActivity(), Runnable {

    private var mHandler: Handler? = null
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        mHandler = Handler()
        if (savedInstanceState == null) {
            replaceAuthsFragment(LoginFragment())
        }
    }

    /**
     * method called from fragments to replace current fragments
     * @param fragment object of fragment
     */
    fun replaceAuthsFragment(fragment: Fragment) {
        this.fragment = fragment
        mHandler!!.post(this)
    }

    override fun run() {
        // update the main content by replacing fragments

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        val backStateFragmentName = fragment!!.javaClass.name
        val fragmentManager = supportFragmentManager
        val fragmentPopped = fragmentManager.popBackStackImmediate(backStateFragmentName, 0)
        if (!fragmentPopped && fragmentManager.findFragmentByTag(backStateFragmentName) == null) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out)
            fragmentTransaction.replace(R.id.frame_auth, fragment, backStateFragmentName)
            fragmentTransaction.addToBackStack(backStateFragmentName)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}