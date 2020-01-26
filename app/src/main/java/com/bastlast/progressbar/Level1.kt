package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level1.*
import java.io.FileOutputStream


class Level1 : AppCompatActivity() {
    private var id = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)
    }

    fun add(view: View) {
        id += 20
        progress_horizontal.setProgress(id,true)
        if(id>=100){
            gotoLevel2()
        }
    }

    private fun gotoLevel2() {
        val file= "save"
        val data = "2"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level2Intent = Intent(applicationContext, Level2::class.java)
        startActivity(level2Intent)
        finish()
    }
}
