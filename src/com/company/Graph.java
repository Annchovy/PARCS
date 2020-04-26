package com.company;

import java.io.*;
import java.util.*;

public class Graph {

    public HashMap<String, Node> hashNodes = new HashMap<>();
    private Set<Node> nodes = new HashSet<>();

    public Graph(String fileName)throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(
                fileName));
        String line = reader.readLine();
        while (line != null) {
            String[] splited = line.split(" ");
            Node nodeFirst;
            Node nodeSecond;
            if (this.hashNodes.containsKey(splited[0])) {
                nodeFirst = this.hashNodes.get(splited[0]);
            } else {
                nodeFirst = new Node(splited[0]);
            }
            if (this.hashNodes.containsKey(splited[1])) {
                nodeSecond = this.hashNodes.get(splited[1]);
            } else {
                nodeSecond = new Node(splited[1]);
            }
            nodeFirst.addDestination(nodeSecond, Integer.parseInt(splited[2]));
            if (!this.hashNodes.containsKey(splited[0])) {
                this.addNode(splited[0], nodeFirst);
            }
            if (!this.hashNodes.containsKey(splited[1])) {
                this.addNode(splited[1], nodeSecond);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public void addNode(String name, Node nodeA) {
        nodes.add(nodeA);
        hashNodes.put(name, nodeA);
    }

    public void printDistances(Node nodeStart)
            throws IOException {
        FileWriter fileWriter = new FileWriter("results");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Node node : nodes) {
            String str = "From " + nodeStart.getName() + " to " + node.getName() + " is " + node.getDistance().toString() + "\n";
            printWriter.print(str);
        }
        printWriter.close();
    }
}