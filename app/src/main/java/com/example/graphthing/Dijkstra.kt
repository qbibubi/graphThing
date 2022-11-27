package com.example.graphthing

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue

data class Cost(val node: Int, val cost: Int)

class Dijkstra(graph: Graph) : AlgorithmStrategy(graph) {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun pathfind(start: Int, end: Int) : Path? {

        // Previous node to current one
        val prev = MutableList(graph.nodes) {
            -1
        }

        // Set all costs to non-positive number
        val costs = MutableList(graph.nodes) {
            -1
        }

        // Start cost
        costs[start] = 0

        val q = PriorityQueue<Cost>(compareBy { it.cost })
        q.add(Cost(start, 0))

        while (!q.isEmpty()) {
            val curr = q.remove()

            graph.adjacencyList[curr.node].forEach { vertex ->
                if(curr.cost + vertex.c > costs[vertex.n] && costs[vertex.n] != -1) {
                    return@forEach
                }

                costs[vertex.n] = curr.cost + vertex.c
                prev[vertex.n] = curr.node
                q.add(Cost(vertex.n, costs[vertex.n]))
            }
        }

        // Guard
        if (prev[end] == -1)
            return null

        // Path calculation
        val path: MutableList<Int> = mutableListOf()
        var i: Int = end

        do {
            path.add(i)
            i = prev[i]
        } while(i != start)

        return Path(path.reversed(), costs[end])
    }
}