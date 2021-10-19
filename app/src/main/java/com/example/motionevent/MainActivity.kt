package com.example.motionevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.example.motionevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.activityMain.setOnTouchListener { v: View, m: MotionEvent ->

            handleTouch(m)

            true
        }
    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount
        for (i in 0 until pointerCount) {
            //get the x and y co-ordinates for each touch
            val x = m.getX(i)
            val y = m.getY(i)

            //get the pointer Id for each touch
            val id = m.getPointerId(i)

            //get the Action data for each touch
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String

            //A super dupa kotlin switch statement
            when (action) {
                MotionEvent.ACTION_DOWN -> actionString = "DOWN"

                MotionEvent.ACTION_UP -> actionString = "UP"

                MotionEvent.ACTION_POINTER_DOWN -> actionString = "PNTR DOWN"

                MotionEvent.ACTION_POINTER_UP -> actionString = "PNTR UP"

                MotionEvent.ACTION_MOVE -> actionString = "MOVE"

                else -> actionString = ""
            }

            val touchStatus =
                "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"

            if (id == 0)

                binding.topTextView.text = touchStatus
            else

                binding.bottomTextView.text = touchStatus
        }
    }
}