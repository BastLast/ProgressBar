package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level5.*
import java.io.FileOutputStream

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
                    Thread.sleep(1500)
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
        id += 15
        progress_horizontal.setProgress(id, true)
        if (id >= 100) {
            gotoLevel6()
        }
    }

    private fun gotoLevel6() {
        val file= "save"
        val data = "6"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream= openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level6Intent = Intent(applicationContext, Level6::class.java)
        startActivity(level6Intent)
        finish()
    }
}
