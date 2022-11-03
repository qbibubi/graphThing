package com.example.graphthing

data class Cost(val node: Int, val e: Int)

class DijkstraPathfinding(graph: GraphBase) : AlgorithmStrategy(graph) {
    override fun Pathfind(s: Int, e: Int): Path? {
        TODO("Not yet implemented")
    }
}