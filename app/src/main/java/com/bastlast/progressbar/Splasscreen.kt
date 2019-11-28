package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splasscreen.*

class Splasscreen : AppCompatActivity() {

    private val splashTime = 1000L // 1 seconds
    private lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splasscreen)

        var id = 0
        Thread(Runnable
        {
            while (id <= 100) {
                progress_horizontal.setProgress(id);
                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                id++
            }
        }).start()

        myHandler = Handler()
        myHandler.postDelayed({
            goToMainActivity()
        }, splashTime)
    }

    private fun goToMainActivity() {
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(mainActivityIntent)
        finish()
    }



}

