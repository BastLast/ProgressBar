package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level4.*
import java.io.FileOutputStream

class Level4 : AppCompatActivity() {
    private var id = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level4)
        layout.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeRight() {
                id += 15
                progress_horizontal.setProgress(id, true)
                if (id >= 100) {
                    gotoLevel5()
                }
            }
        })
    }

    private fun gotoLevel5() {
        val file= "save"
        val data = "5"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level5Intent = Intent(applicationContext, Level5::class.java)
        startActivity(level5Intent)
        finish()
    }
}

