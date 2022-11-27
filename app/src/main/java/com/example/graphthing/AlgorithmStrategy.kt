package com.example.graphthing

data class Path(val nodes: List<Int>,
                val cost: Int)

abstract class AlgorithmStrategy(val graph: GraphBase) {
    abstract fun pathfind(start: Int, end: Int) : Path?
}
