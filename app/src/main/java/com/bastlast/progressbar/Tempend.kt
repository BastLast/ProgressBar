package com.bastlast.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.ActivityNotFoundException
import android.content.Context
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.view.View
import java.io.FileOutputStream


class Tempend : AppCompatActivity() {

    fun rate(view: View) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$packageName")
                )
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                )
            )
        }
    }

    fun restart(view: View) {
        val file= "save"
        val data = "1"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level1Intent = Intent(applicationContext, Level1::class.java)
        startActivity(level1Intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempend)
    }
}
