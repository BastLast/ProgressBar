package com.example.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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

