package com.example.graphthing

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    // late declaration of views
    private lateinit var startPoint: NumberPicker
    private lateinit var endPoint: NumberPicker
    private lateinit var nodeCost: NumberPicker
    private lateinit var connectButton: Button
    private lateinit var applyButton: Button
    private lateinit var graphButton: Button
    private lateinit var outcomeTextView: TextView
    private lateinit var graphTextView: TextView
    private lateinit var mainGraph: GraphBase

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // definitions of views and buttons
        startPoint = findViewById(R.id.startPoint)
        endPoint = findViewById(R.id.endPoint)
        nodeCost = findViewById(R.id.nodeCost)
        applyButton = findViewById(R.id.applyButton)
        graphButton = findViewById(R.id.graphButton)
        connectButton = findViewById(R.id.connectButton)
        outcomeTextView = findViewById(R.id.outcomeTextView)
        graphTextView = findViewById(R.id.graphView)

        graphButton.setOnClickListener {
            mainGraph = GraphBase(10, 5, 10)
            graphTextView.text = mainGraph.adjacentMatrix.toString()
        }

        applyButton.setOnClickListener {
            val dijkstra = DijkstraPathfinding(mainGraph)
            val path = dijkstra.Pathfind(
                startPoint.value,
                endPoint.value
            )
            outcomeTextView.text = path.toString()
        }

        connectButton.setOnClickListener {
            // TODO(IMPLEMENT CONNECTING)
        }

        // start, end point, node cost values
        startPoint.minValue = 0
        startPoint.maxValue = 9
        endPoint.minValue = 0
        endPoint.maxValue = 9
        nodeCost.minValue = 0
        nodeCost.maxValue = 1
    }
}