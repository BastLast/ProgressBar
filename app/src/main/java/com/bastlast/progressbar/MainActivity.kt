package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoLevel1(view: View) {
        val level1Intent = Intent(applicationContext, Level1::class.java)
        startActivity(level1Intent)
        finish()
    }

}

