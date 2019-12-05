package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splasscreen.*

class Level2 : AppCompatActivity() {
    private var id = 0
    private var lastbutton = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2)
    }

    fun first(view: View) {
        if (lastbutton != 1) {
            id += 10
            lastbutton = 1
            progress_horizontal.setProgress(id, true);
            if (id >= 100) {
                gotoLevel3()
            }
        } else {
            id = 0
            progress_horizontal.setProgress(id, true);
        }

    }

    fun second(view: View) {
        if (lastbutton != 2) {
            id += 10
            lastbutton = 2
            id += 10
            progress_horizontal.setProgress(id, true);
            if (id >= 100) {
                gotoLevel3()
            }
        } else {
            id = 0
            progress_horizontal.setProgress(id, true);
        }
    }

    private fun gotoLevel3() {
        val level3Intent = Intent(applicationContext, Level3::class.java)
        startActivity(level3Intent)
        finish()
    }
}
