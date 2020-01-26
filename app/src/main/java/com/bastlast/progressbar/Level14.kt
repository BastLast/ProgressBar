package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level14.*
import java.io.FileOutputStream

class Level14 : AppCompatActivity() {

    private var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level14)
        Thread(Runnable
        {
            while (id < 100) {
                if (Power.isConnected(applicationContext)) {
                    id = 50
                } else {
                    if (id == 50) {
                        id = 100
                        gotoLevel15()
                    }
                }
                progress_horizontal.setProgress(id, true)
                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    private fun gotoLevel15() {
        val file = "save"
        val data = "15"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val level15Intent = Intent(applicationContext, Level15::class.java)
        startActivity(level15Intent)
        finish()
    }

    object Power {
        fun isConnected(context: Context): Boolean {
            val intent = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
            val plugged = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            return plugged == BatteryManager.BATTERY_PLUGGED_AC || plugged == BatteryManager.BATTERY_PLUGGED_USB || plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS
        }
    }

}

