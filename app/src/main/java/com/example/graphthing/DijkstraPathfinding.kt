package com.example.graphthing

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue

data class Cost(val node: Int, val cost: Int)

class DijkstraPathfinding(graph: GraphBase) : AlgorithmStrategy(graph) {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun Pathfind(start: Int, end: Int) : Path? {

        // Previous node to current one
        val prev = MutableList(graph.nodes) {
            -1
        }

        // Lowest current cost from s
        val costs = MutableList(graph.nodes) {
            -1
        }

        // Distance from start
        costs[start] = 0

        val q = PriorityQueue<Cost>(compareBy { it.cost })
        q.add(Cost(start, 0))

        while (!q.isEmpty()) {
            val curr = q.remove()

            graph.adjacentMatrix[curr.node].forEach { vertex ->
                if(curr.cost + vertex.cost > costs[vertex.node]
                    && costs[vertex.node] != -1) {
                    return@forEach
                }

                costs[vertex.node] = curr.cost + vertex.cost
                prev[vertex.node] = curr.node
                q.add(Cost(vertex.node, costs[vertex.node]))
            }
        }

        // Guard
        if (prev[end] == -1)
            return null

        // Path calculation
        var path: MutableList<Int> = mutableListOf<Int>()
        var i: Int = end

        do {
            path.add(i)
            i = prev[i]
        } while(i != start)

        return Path(path.reversed(), costs[end])
    }
}