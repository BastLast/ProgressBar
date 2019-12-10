package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level5.*

class Level5 : AppCompatActivity() {
    private var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level5)
        Thread(Runnable
        {
            while (id <= 100) {
                reset()
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    private fun reset() {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    fun add(view: View) {
        id += 20
        progress_horizontal.setProgress(id, true)
        if (id >= 100) {
            gotoLevel6()
        }
    }

    private fun gotoLevel6() {
        val level6Intent = Intent(applicationContext, Level6::class.java)
        startActivity(level6Intent)
        finish()
    }
}
