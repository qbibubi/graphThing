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
        // Mutable adjacent matrix for nodes
        val mutAdjacentMatrix: List<MutableList<Vertex>> = List(nodes) {
            mutableListOf()
        }

        // Mutable list of edges
        val mutEdgesList = MutableList(edges) {
            Edge(0, 0, 0)
        }

        for (i in 0 until edges) {
            // Randomly generate first, second node and their cost
            val firstNode = Random.nextInt(nodes)
            val secondNode= Random.nextInt(nodes - 1)
            val cost = Random.nextInt(1, maxCost)
1
            //
            mutAdjacentMatrix[firstNode].add(Vertex(secondNode, cost))
            mutAdjacentMatrix[secondNode].add(Vertex(firstNode, cost))
            mutEdgesList.add(Edge(firstNode, secondNode, cost))
        }

        adjacentMatrix = mutAdjacentMatrix
        edgesList = mutEdgesList
    }
}