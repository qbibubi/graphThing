package com.example.graphthing

data class Path(val nodes: List<Int>,
                val cost: Int)

abstract class AlgorithmStrategy(val graph: GraphBase) {
    abstract fun Pathfind(s: Int,
                          e: Int) : Path?
}
