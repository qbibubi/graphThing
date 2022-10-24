package com.example.graphthing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ii: Button = findViewById(R.id.incrementButtonI)
        val ij: Button = findViewById(R.id.incrementButtonJ)
        val di: Button = findViewById(R.id.decrementButtonI)
        val dj: Button = findViewById(R.id.decrementButtonJ)
        val apply: Button = findViewById(R.id.applyButton)

        var v1: Int = 0
        var v2: Int = 0
        var e: Int = 0

        var V = ArrayList<Int>()
        var E = ArrayList<Int>()

        ii.setOnClickListener { v1++ }
        ij.setOnClickListener { v2++ }
        di.setOnClickListener { v1-- }
        dj.setOnClickListener { v2-- }

        // debug part for now on
        apply.setOnClickListener {
            Log.d("i", v1.toString())
            Log.d("j", v2.toString())

        }
    }
}