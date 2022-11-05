package com.example.graphthing

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    // Late declaration of objects
    private lateinit var startPoint: NumberPicker
    private lateinit var endPoint: NumberPicker
    private lateinit var applyButton: Button
    private lateinit var outcomeTextView: TextView
    private lateinit var mainGraph: GraphBase

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definitions of objects
        startPoint = findViewById(R.id.startPoint)
        endPoint = findViewById(R.id.endPoint)
        applyButton = findViewById(R.id.applyButton)
        outcomeTextView = findViewById(R.id.outcomeTextView)

        // Main graph declaration
        mainGraph = GraphBase(20, 20, 10)

        applyButton.setOnClickListener {
            val dijkstra = DijkstraPathfinding(mainGraph)
            val path = dijkstra.Pathfind(
                startPoint.value,
                endPoint.value
            )

            outcomeTextView.text = path.toString()
        }

        // Start and end point values
        startPoint.minValue = 0
        startPoint.maxValue = 9
        endPoint.minValue = 0
        endPoint.maxValue = 9
    }
}