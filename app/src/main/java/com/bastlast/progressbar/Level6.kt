package com.bastlast.progressbar

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_level6.*

class Level6 : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var light: Sensor? = null
    private var id = 0
    private var echelle = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level6)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent) {
        val light = event.values[0]
        val lightvalue = light.toInt()
        if (echelle == 0) echelle = (lightvalue*1.2).toInt()
        id = 100- (100 * lightvalue/echelle)
        progress_horizontal.setProgress(id, true);
        if (id >= 100) {
            gotoLevel7()
        }
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    fun add(view: View) {
        id += 80
        echelle = 0
    }

    private fun gotoLevel7() {
        val level7Intent = Intent(applicationContext, Level7::class.java)
        startActivity(level7Intent)
        finish()
    }

}
