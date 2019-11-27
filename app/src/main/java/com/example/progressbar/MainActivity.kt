package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_horizontal.setProgress(0)

        plusBtn.setOnClickListener {
            progress_horizontal.setProgress( ++ id)
        }

        minusBtn.setOnClickListener {
            progress_horizontal.setProgress( -- id)
        }
    }
}
