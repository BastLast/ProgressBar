package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //goToSplashActivity()
        setContentView(R.layout.activity_main)

    }

    private fun goToSplashActivity(){
        val splashActivityIntent = Intent(applicationContext, Splasscreen::class.java)
        startActivity(splashActivityIntent)
        finish()
    }

}

