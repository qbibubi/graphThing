package com.example.graphthing

import kotlin.random.Random

data class Edge(val nodeFirst: Int,
                val nodeSecond: Int,
                val cost: Int)

data class Vertex(val node: Int,
                  val cost: Int)

class GraphBase(val nodes: Int, val edges: Int) {
    lateinit var adjacentMatrix: List<List<Vertex>>
    lateinit var edgesList: List<Edge>

    constructor(nodes: Int = 10,
                edges: Int = 5,
                maxCost: Int = 10
                ) : this(nodes, edges)
    {
        val mutAdjacentMatrix: List<MutableList<Vertex>> = List(nodes) {
            mutableListOf()
        }

        val mutEdges = MutableList(edges) {
            Edge(0, 0, 0)
        }

        for (i in 0 until edges) {
            val node = Random.nextInt(nodes)
            val randomNode= Random.nextInt(nodes - 1)


        }
    }
}