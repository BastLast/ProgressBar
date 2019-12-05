package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splasscreen.*

class Level3 : AppCompatActivity() {
    private var id = 0
    private var speed = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level3)
        Thread(Runnable
        {
            while (id <= 100) {
                speed = 0
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    fun add(view: View) {
        if (speed == 0) {
            id += 20
            speed = 1
            progress_horizontal.setProgress(id, true);
            if (id >= 100) {
                gotoLevel4()
            }
        } else {
            id = 0
            progress_horizontal.setProgress(id, true);
        }
    }

    private fun gotoLevel4() {
        val level4Intent = Intent(applicationContext, Level4::class.java)
        startActivity(level4Intent)
        finish()
    }
}
