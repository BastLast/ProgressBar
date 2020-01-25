package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level3.*
import java.io.FileOutputStream

class Level9 : AppCompatActivity() {
    private var id = 0
    private var speed = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level9)
        Thread(Runnable
        {
            while (id <= 100) {
                reset()
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }


    fun add(view: View) {
        id += 9
        progress_horizontal.setProgress(id, true)
        if (id >= 100) {
            gotoLevel10()
        }
    }

    private fun reset() {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel10() {val file= "save"
        val data = "10"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }

        val level10Intent = Intent(applicationContext, Level10::class.java)
        startActivity(level10Intent)
        finish()
    }
}
