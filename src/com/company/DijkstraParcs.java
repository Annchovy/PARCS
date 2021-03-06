package com.company;

import org.apache.commons.lang.SerializationUtils;
import parcs.*;

import java.io.IOException;


public class DijkstraParcs implements AM {
    public void run(AMInfo info){
        Graph graph = (Graph) info.parent.readObject();
        String nodes;
        nodes = (String) info.parent.readObject();
        String[] splited = nodes.split(" ");
        for (String name : splited) {
            try {
                Graph new_graph = Dijkstra.calculateShortestPathFromSource(graph, graph.hashNodes.get(name));
                String result = new_graph.printDistances(graph.hashNodes.get(name));
                info.parent.write(result);
            } catch (IOException ex) {

            }
        }
    }
}
