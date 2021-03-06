package com.bastlast.progressbar

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

open class OnSwipeTouchListener : View.OnTouchListener {

    private val gestureDetector = GestureDetector(GestureListener())

    fun onTouch(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        private val SWIPETHRESHOLD = 100
        private val SWIPEVELOCITYTHRESHOLD = 100

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            onTouch(e)
            return true
        }


        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > SWIPETHRESHOLD && abs(velocityX) > SWIPEVELOCITYTHRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }

            return result
        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    open fun onSwipeRight() {
    }

    open fun onSwipeLeft() {}

}