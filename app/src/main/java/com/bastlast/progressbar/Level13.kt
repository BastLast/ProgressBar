package com.bastlast.progressbar

import android.annotation.SuppressLint
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
    private var id = 0
    private var success = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level13)
    }

    fun bpressed(view: View) {
        progressvisualy()
        success = id == 17
        testReset(view)
    }

    fun otherpressed(view: View) {
        progressvisualy()
        success = false
        testReset(view)
    }

    private fun testReset(view: View) {
        if (id >= 100) {
            success = true
            reset(view)
        }
    }

    fun apressed(view: View) {
        progressvisualy()
        if (!(id == 34 || id == 68)) {
            success = false
            testReset(view)
        }

    }

    fun npressed(view: View) {
        progressvisualy()
        if (!(id == 51 || id == 85)) {
            success = false
            testReset(view)
        }

    }

    private fun progressvisualy() {
        id += 17
        progress_horizontal.setProgress(id, true)
    }

    fun epressed(view: View) {
        if (id == 85 && success) {
            gotoLevel14()
        } else {
            progressvisualy()
            testReset(view)
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
        val level14Intent = Intent(applicationContext, Level14::class.java)
        startActivity(level14Intent)
        finish()
    }
}
