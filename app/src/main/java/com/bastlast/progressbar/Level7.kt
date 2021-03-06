package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_level7.progress_horizontal
import java.io.FileOutputStream

class Level7 : AppCompatActivity() {

    private var id = 0
    private var coups = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level7)
    }

    fun add1(view: View) {
        id += 58
        savestep()
    }

    fun add2(view: View) {
        id += 29
        savestep()
    }

    fun add3(view: View) {
        id += 42
        savestep()
    }

    private fun savestep() {
        progress_horizontal.setProgress(id, true)
        if (id > 100) {
            reset()
        }
        if (id == 100) {
            gotoLevel8()
        }
    }

    private fun reset() {
        id = 0
        coups = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel8() {
        val file= "save"
        val data = "8"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level8Intent = Intent(applicationContext, Level8::class.java)
        startActivity(level8Intent)
        finish()
    }

}
