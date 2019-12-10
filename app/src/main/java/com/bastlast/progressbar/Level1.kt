package com.bastlast.progressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splasscreen.*

class Level1 : AppCompatActivity() {
    private var id = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)
    }

    fun add(view: View) {
        id += 20
        progress_horizontal.setProgress(id,true);
        if(id>=100){
            gotoLevel2()
        }
    }

    private fun gotoLevel2() {
        val level2Intent = Intent(applicationContext, Level2::class.java)
        startActivity(level2Intent)
        finish()
    }
}
