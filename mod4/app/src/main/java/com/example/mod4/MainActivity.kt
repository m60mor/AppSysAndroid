package com.example.mod4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class StartTimer(private val n1: TextView, private val n2: TextView, private val n3: TextView, private val n4: TextView) : Thread() {

    private var isRunning = false
    private var time : Int = 10000

    fun isRunning() : Boolean {
        return isRunning
    }
    fun startTimer() {
        isRunning = true
    }
    fun stopTimer() {
        isRunning = false
    }
    fun resetTimer() {
        time = 10000
    }

    override fun run() {
        while (isRunning) {
            time ++
            if (time.toString()[3] == '6') {
                time += 40
            }
            n1.post {
                n1.text = time.toString()[1].toString()
            }
            n2.post {
                n2.text = time.toString()[2].toString()
            }
            n3.post {
                n3.text = time.toString()[3].toString()
            }
            n4.post {
                n4.text = time.toString()[4].toString()
            }
            sleep(1000) // Sleep for 1 second
        }
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart = findViewById<Button>(R.id.start)
        val buttonStop = findViewById<Button>(R.id.stop)
        val buttonReset = findViewById<Button>(R.id.reset)
        val number1 = findViewById<TextView>(R.id.num1)
        val number2 = findViewById<TextView>(R.id.num2)
        val number3 = findViewById<TextView>(R.id.num3)
        val number4 = findViewById<TextView>(R.id.num4)
        val t = StartTimer(number1, number2, number3, number4)

        buttonStart.setOnClickListener {
            if (!t.isRunning()) {
                t.start()
                t.startTimer()
            }
        }
        buttonStop.setOnClickListener {
            t.stopTimer()
        }
        buttonReset.setOnClickListener {
            number1.text = "0"
            number2.text = "0"
            number3.text = "0"
            number4.text = "0"
            t.resetTimer()
        }

//
    }
}