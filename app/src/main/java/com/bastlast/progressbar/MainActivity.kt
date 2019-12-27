package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoLevel1(view: View) {
        val currentlevel = getCurrentLevel()
        val leveltoLoad: Intent = getCurrentIntent(currentlevel)
        startActivity(leveltoLoad)
        finish()
    }

    private fun getCurrentIntent(currentlevel: Int): Intent {
        return when (currentlevel) {
            1 -> Intent(applicationContext, Level1::class.java)
            2 -> Intent(applicationContext, Level2::class.java)
            3 -> Intent(applicationContext, Level3::class.java)
            4 -> Intent(applicationContext, Level4::class.java)
            5 -> Intent(applicationContext, Level5::class.java)
            6 -> Intent(applicationContext, Level6::class.java)
            7 -> Intent(applicationContext, Level7::class.java)
            8 -> Intent(applicationContext, Level8::class.java)
            9 -> Intent(applicationContext, Level9::class.java)
            10 -> Intent(applicationContext, Level10::class.java)
            11 -> Intent(applicationContext, Level11::class.java)
            12 -> Intent(applicationContext, Level12::class.java)
            13 -> Intent(applicationContext, Level13::class.java)
            //else -> Intent(applicationContext, Level13::class.java)
            else -> Intent(applicationContext, Tempend::class.java)
        }
    }

    private fun getCurrentLevel(): Int {
        var currentlevel1 = 0
        var fileInputStream: FileInputStream? = null
        val file = this.getFileStreamPath("save")
        if (file == null || !file.exists()) {
            currentlevel1 = 1
        } else {
            fileInputStream = openFileInput("save")
            val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
            }
            //Displaying data on EditText
            currentlevel1 = stringBuilder.toString().toInt()
        }
        return currentlevel1
    }

    fun goabout(view: View) {
        val aboutIntent = Intent(applicationContext, about::class.java)
        startActivity(aboutIntent)
        finish()
    }

}

