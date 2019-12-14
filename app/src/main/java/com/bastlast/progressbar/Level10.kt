package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level3.*

class Level10 : AppCompatActivity() {
    private var id = 0
    private var speed = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level9)
    }

    fun add(view: View) {
        if (speed == 0) {
            id += 15
            speed = 1
            progress_horizontal.setProgress(id, true)
            if (id >= 100) {
                gotoLevel10()
            }
        } else {
            reset()
        }
        Thread(Runnable
        {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            speed = 0
        }).start()
        Thread(Runnable
        {
            val memory = id
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            if (memory == id) {
                id=0
            }
            progress_horizontal.setProgress(id, true)
        }).start()
    }

    private fun reset() {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel10() {
        val level10Intent = Intent(applicationContext, Level10::class.java)
        startActivity(level10Intent)
        finish()
    }
}
