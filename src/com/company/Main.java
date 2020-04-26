package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)
            throws IOException {
        Graph graph = new Graph("graph");
        graph = Dijkstra.calculateShortestPathFromSource(graph, graph.hashNodes.get("A"));
        graph.printDistances(graph.hashNodes.get("A"));
    }
}
