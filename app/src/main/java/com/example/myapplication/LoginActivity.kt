package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class LoginActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var button = findViewById<Button>(R.id.buttonContinue)
        button.isEnabled = false
        var input = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var input_yan = findViewById<Button>(R.id.button2)
        input_yan.setBackgroundResource(0)

        input.addTextChangedListener {
            button.isEnabled = input.text.isNotEmpty()
        }

        button.setOnClickListener {
            var intent = Intent(this@LoginActivity, HubActivity::class.java)
            startActivity(intent)
        }
    }


}