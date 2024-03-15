package com.amalwin.statehandlingwithoutjetpackcompose

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.text = "Count is $count"
        button.setOnClickListener {
            button.text = "Count is ${++count}"
            Toast.makeText(this, "Incremented count : $count", Toast.LENGTH_LONG).show()
        }
    }
}