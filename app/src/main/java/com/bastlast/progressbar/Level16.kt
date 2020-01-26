package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_level14.*
import kotlinx.android.synthetic.main.activity_level14.progress_horizontal
import kotlinx.android.synthetic.main.activity_level16.*
import java.io.FileOutputStream

class Level16 : AppCompatActivity() {
    private var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level16)
        Thread(Runnable
        {
            while (id < 100) {
                id = android.provider.Settings.System.getInt(
                    applicationContext.getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS)
                id /= 2;
                progress_horizontal.setProgress(id, true)
                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            gotoLevel17()
        }).start()
    }

    private fun gotoLevel17() {
        val file = "save"
        val data = "17"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val level17Intent = Intent(applicationContext, Tempend::class.java)
        startActivity(level17Intent)
        finish()
    }
}
