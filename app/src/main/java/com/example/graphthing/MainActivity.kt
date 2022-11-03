package com.example.graphthing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var startPoint: NumberPicker
    lateinit var endPoint: NumberPicker
    lateinit var applyButton: Button
    lateinit var outcomeTextView: TextView
    //lateinit var mainGraph: Graph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startPoint = findViewById(R.id.startPoint)
        endPoint = findViewById(R.id.endPoint)
        applyButton = findViewById(R.id.applyButton)
        outcomeTextView = findViewById(R.id.outcomeTextView)

    }
}