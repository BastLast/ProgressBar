package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splasscreen.*
import java.io.FileOutputStream

class Level2 : AppCompatActivity() {
    private var id = 0
    private var lastbutton = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2)
    }

    fun first(view: View) {
        if (lastbutton != 1) {
            lastbutton = 1
            makeprogress()
        } else {
            reset()
        }

    }

    fun second(view: View) {
        if (lastbutton != 2) {
            lastbutton = 2
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
        id += 10
        progress_horizontal.setProgress(id, true)
        if (id >= 100) {
            gotoLevel3()
        }
    }

    private fun gotoLevel3() {
        val file= "save"
        val data = "3"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level3Intent = Intent(applicationContext, Level3::class.java)
        startActivity(level3Intent)
        finish()
    }
}
