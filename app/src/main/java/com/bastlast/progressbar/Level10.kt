package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level10.*
import java.io.FileOutputStream

class Level10 : AppCompatActivity() {
    private var id = 1
    private var sens = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level10)
        layout.setOnTouchListener(object : OnSwipeTouchListener() {

            override fun onSwipeRight() {
                horizontalSwipe()
            }

            override fun onSwipeLeft() {
                verticalSwipe()
            }

        })
    }

    private fun horizontalSwipe() {
        if (sens) {
            sens = false
            id += 10
            progress_horizontal.setProgress(id, true)
            if (id >= 100) {
                gotoLevel11()
            }
        } else {
            reset()
        }
    }

    private fun verticalSwipe() {
        if (!sens) {
            sens = true
            id += 10
            progress_horizontal.setProgress(id, true)
            if (id >= 100) {
                gotoLevel11()
            }
        } else {
            reset()
        }
    }

    private fun reset() {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel11() {
        val file= "save"
        val data = "11"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level11Intent = Intent(applicationContext, Level11::class.java)
        startActivity(level11Intent)
        finish()
    }
}
