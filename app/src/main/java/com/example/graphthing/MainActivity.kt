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
    private lateinit var startPoint: NumberPicker
    private lateinit var endPoint: NumberPicker
    private lateinit var nodeCost: NumberPicker
    private lateinit var isConnected: NumberPicker

    private lateinit var connectButton: Button
    private lateinit var applyButton: Button
    private lateinit var graphButton: Button

    private lateinit var outcomeTextView: TextView
    private lateinit var graphTextView: TextView

    private lateinit var mainGraph: Graph

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // definitions of views and buttons
        startPoint = findViewById(R.id.startPoint)
        endPoint = findViewById(R.id.endPoint)
        nodeCost = findViewById(R.id.nodeCost)
        isConnected = findViewById(R.id.isConnected)

        applyButton = findViewById(R.id.applyButton)
        graphButton = findViewById(R.id.graphButton)
        connectButton = findViewById(R.id.connectButton)

        outcomeTextView = findViewById(R.id.outcomeTextView)
        graphTextView = findViewById(R.id.graphView)

        // Construct a graph
        mainGraph = Graph()

        // Output graph and edges to the screen
        graphButton.setOnClickListener {
            graphTextView.text = mainGraph.adjacencyList.toString() + '\n' + '\n' + mainGraph.edgesList.toString()
        }

        // Find path with Dijkstra and output it to string
        applyButton.setOnClickListener {
            val dijkstra = Dijkstra(mainGraph)
            val path = dijkstra.pathfind(startPoint.value, endPoint.value)

            // path to string
            outcomeTextView.text = path.toString()
        }

        // Connect selected nodes on click
        connectButton.setOnClickListener {
            val i = startPoint.value
            val j = endPoint.value
            val c = nodeCost.value

            if (isConnected.value == 0) {
                mainGraph.removeEdge(i, j, c)
            }

            mainGraph.addEdge(i, j, c)
        }

        // start, end point, node cost, connected
        startPoint.minValue = 0
        startPoint.maxValue = 9
        endPoint.minValue = 0
        endPoint.maxValue = 9
        nodeCost.minValue = 0
        nodeCost.maxValue = 9
        isConnected.minValue = 0
        isConnected.maxValue = 1
    }
}