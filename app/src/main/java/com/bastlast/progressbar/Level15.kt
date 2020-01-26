package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splasscreen.*
import java.io.FileOutputStream

class Level15 : AppCompatActivity() {
    private var id = 0
    private var lastbutton = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level15)
    }

    fun first(view: View) {
        if (lastbutton<2) {
            lastbutton++
            makeprogress()
        } else {
            reset()
        }

    }

    fun second(view: View) {
        if (lastbutton == 2) {
            lastbutton = 0
            makeprogress()
        } else {
            reset()
        }
    }

    private fun reset() {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun makeprogress() {
        id += 6
        progress_horizontal.setProgress(id, true)
        if (id >= 100) {
            gotoLevel16()
        }
    }

    private fun gotoLevel16() {
        val file = "save"
        val data = "16"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val level16Intent = Intent(applicationContext, Level16::class.java)
        startActivity(level16Intent)
        finish()
    }
}
