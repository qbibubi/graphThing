package com.example.graphthing

import kotlin.random.Random

data class Edge(val n1: Int, val n2: Int, val c: Int)
data class Vertex(val n: Int, val c: Int)

class Graph(val nodes: Int, val edges: Int) {
    lateinit var adjacencyList: List<List<Vertex>>
    lateinit var edgesList: List<Edge>

    constructor(nodes: Int = 10, edges: Int = 5, maxCost: Int = 10) : this(nodes, edges)
    {
        val mutAdjacencyList: List<MutableList<Vertex>> = List(nodes) { mutableListOf() }
        val mutEdgesList = MutableList(edges) { Edge(0, 0, 0) }

        for (i in 0 until edges) {
            val firstNode = Random.nextInt(nodes)
            val secondNode = Random.nextInt(nodes - 1)
            val cost = Random.nextInt(1, maxCost)

            // Add nodes to mutable adjacent matrix
            mutAdjacencyList[firstNode].add(Vertex(secondNode, cost))
            mutAdjacencyList[secondNode].add(Vertex(firstNode, cost))
            mutEdgesList.add(Edge(firstNode, secondNode, cost))
        }

        // Set main matrix and edges lists
        // with adjacent matrix and list
        adjacencyList = mutAdjacencyList
        edgesList = mutEdgesList
    }


    fun addEdge(n1: Int, n2: Int, c: Int) {

    }

    fun removeEdge(n1: Int, n2: Int, c: Int) {

    }

}