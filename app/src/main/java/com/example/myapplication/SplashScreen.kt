package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Math.abs

class SplashScreen : AppCompatActivity(), GestureDetector.OnGestureListener {

    lateinit var gestureDetector: GestureDetector

    var x1: Float = 0.0f
    var x2: Float = 0.0f
    var y1: Float = 0.0f
    var y2: Float = 0.0f

    companion object {
        const val MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        gestureDetector = GestureDetector(this, this)

        var start_radio_button = findViewById<RadioButton>(R.id.radioButton)
        var second_radio_button = findViewById<RadioButton>(R.id.radioButton2)
        var third_radio_button = findViewById<RadioButton>(R.id.radioButton3)

        var green_text = findViewById<TextView>(R.id.textGreen)
        var bottom_img = findViewById<ImageView>(R.id.colba)
        var second_bottom_img = findViewById<ImageView>(R.id.imageView2)
        var third_bottom_img = findViewById<ImageView>(R.id.imageView3)
        var desc_text = findViewById<TextView>(R.id.description_text)

        start_radio_button.isEnabled = false
        second_radio_button.isEnabled = false
        third_radio_button.isEnabled = false

        when (event?.action) {
            0 -> {
                x1 = event.x
                y1 = event.y
            }
            1 -> {
                x2 = event.x
                y2 = event.y

                val valueX: Float = x2 - x1

                if (abs(valueX) > MIN_DISTANCE) {
                    if (x2 > x1) {
                        if (!start_radio_button.isChecked) {
                            if (second_radio_button.isChecked) {
                                second_radio_button.isChecked = false
                                start_radio_button.isChecked = true

                                green_text.text="Анализы"
                                desc_text.text="Экспресс сбор и получения проб"
                                bottom_img.visibility = View.VISIBLE
                                second_bottom_img.visibility = View.INVISIBLE

                            } else if  (third_radio_button.isChecked) {
                                third_radio_button.isChecked = false
                                second_radio_button.isChecked = true

                                green_text.text="Уведомления"
                                desc_text.text="Вы быстро узнаете о результатах"

                                third_bottom_img.visibility = View.INVISIBLE
                                second_bottom_img.visibility = View.VISIBLE
                            }
                        }
                    } else {
                        if (!third_radio_button.isChecked) {
                            if (start_radio_button.isChecked) {

                                start_radio_button.isChecked = false
                                second_radio_button.isChecked = true

                                green_text.text="Уведомления"
                                desc_text.text="Вы быстро узнаете о результатах"

                                bottom_img.visibility = View.INVISIBLE
                                second_bottom_img.visibility = View.VISIBLE

                            } else if (second_radio_button.isChecked) {
                                second_radio_button.isChecked = false
                                third_radio_button.isChecked = true

                                green_text.text="Мониторинг"
                                desc_text.text="    Наши врачи всегда наблюдают \nза вашими показателями здоровья"

                                second_bottom_img.visibility = View.INVISIBLE
                                third_bottom_img.visibility = View.VISIBLE
                            }
                        }
                        //else if (third_radio_button.isChecked) {
                            //var intent = Intent(this@FirstInfoScreenActivity, LoginActivity::class.java)
                           // startActivity(intent)
                        //}
                    }
                }
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
        TODO("Not yet implemented")
    }

    override fun onShowPress(e: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        TODO("Not yet implemented")
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLongPress(e: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        TODO("Not yet implemented")
    }


}