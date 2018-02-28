package com.loginformkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity(), Runnable {

    private var handler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler = Handler()
        handler!!.postDelayed(this, SPLASH_DELAY)
    }

    override fun run() {
        val intent = Intent(applicationContext, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}