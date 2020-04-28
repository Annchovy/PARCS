package com.company;

import org.apache.commons.lang.SerializationUtils;
import parcs.*;


public class DijkstraParcs implements AM {
    public void run(AMInfo info){
        byte[] data = new byte[0];
        info.parent.read(data);
        Graph graph = (Graph) SerializationUtils.deserialize(data);
        String nodes;
        nodes = (String) info.parent.readObject();

        info.parent.write(r);
    }
}
