package com.example.mod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart = findViewById<Button>(R.id.start)
        val number1 = findViewById<TextView>(R.id.num1)

        buttonStart.setOnClickListener {
            number1.text = "5"
        }
    }
}