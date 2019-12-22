package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_level8.*
import java.io.FileOutputStream

class Level8 : AppCompatActivity() {

    private var id = 0
    private var coups = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level8)

        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                var value = i
                value = if (value > 40) {
                    100 - 2 * (value - 40)
                } else {
                    100 * value / 40
                }
                progress_horizontal.setProgress(value, true);

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //nothing to do
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                if (progress_horizontal.progress == 100) {
                    gotoLevel9()
                }
            }
        })
    }

    private fun gotoLevel9() {
        val file= "save"
        val data = "9"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level9Intent = Intent(applicationContext, Level9::class.java)
        startActivity(level9Intent)
        finish()
    }

}
