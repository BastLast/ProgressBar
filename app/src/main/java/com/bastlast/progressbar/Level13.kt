package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level1.*
import kotlinx.android.synthetic.main.activity_level12.*
import kotlinx.android.synthetic.main.activity_level13.*
import kotlinx.android.synthetic.main.activity_level13.progress_horizontal
import java.io.FileOutputStream

class Level13 : AppCompatActivity() {
    private var id = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level13)

    }

    fun bpressed(view: View) {
        id = 17
        progress_horizontal.setProgress(id, true)
    }

    fun apressed(view: View) {
        if (id == 17 || id == 51) {
            id += 17
            progress_horizontal.setProgress(id, true)
        } else {
            reset(view)
        }
    }

    fun npressed(view: View) {
        if (id == 34 || id == 68) {
            id += 17
            progress_horizontal.setProgress(id, true)
        } else {
            reset(view)
        }
    }

    fun epressed(view: View) {
        if (id == 85) {
            gotoLevel14()
        } else {
            reset(view)
        }
    }


    fun reset(view: View) {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel14() {
        val file = "save"
        val data = "14"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val level14Intent = Intent(applicationContext, Tempend::class.java)
        startActivity(level14Intent)
        finish()
    }
}
