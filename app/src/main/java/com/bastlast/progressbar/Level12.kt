package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level1.*
import kotlinx.android.synthetic.main.activity_level12.*
import kotlinx.android.synthetic.main.activity_level12.button
import kotlinx.android.synthetic.main.activity_level12.progress_horizontal
import kotlinx.android.synthetic.main.activity_level7.*
import java.io.FileOutputStream

class Level12 : AppCompatActivity() {

    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level12)
        button.setOnLongClickListener {
            id += 20
            progress_horizontal.setProgress(id, true)
            if (id >= 100) {
                gotoLevel13()
            }
            true
        }
    }

    fun reset(view: View) {
        id = 0
        progress_horizontal.setProgress(id, true)
    }

    private fun gotoLevel13() {
        val file = "save"
        val data = "13"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val level13Intent = Intent(applicationContext, Level13::class.java)
        startActivity(level13Intent)
        finish()
    }

}
