package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level11.*
import java.io.FileOutputStream

class Level11 : AppCompatActivity(), SensorEventListener {

    private var accelerometer: Sensor? = null
    private lateinit var sensorManager: SensorManager
    private var light: Sensor? = null
    private var id = 0
    private var echelle = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level11)
        // get reference of the service
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // focus in accelerometer
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            calculateprogressbarvalue(event)
            progress_horizontal.setProgress(id, true);
            if (id >= 100) {
                gotoLevel12()
            }
        }
    }

    private fun calculateprogressbarvalue(event: SensorEvent) {
        val position = event.values[1]*10
        id = position.toInt()
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    private fun gotoLevel12() {
        val file= "save"
        val data = "12"
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val level12Intent = Intent(applicationContext, Level12::class.java)
        startActivity(level12Intent)
        finish()
    }

}
