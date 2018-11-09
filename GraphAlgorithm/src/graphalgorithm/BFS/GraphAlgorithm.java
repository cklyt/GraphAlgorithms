/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithm.BFS;

import graphalgorithm.BFS.Vertex;
import graphalgorithm.BFS.BFS;

/**
 *
 * @author lllyu
 */
public class GraphAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BFS bfs = new BFS();
        
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        
        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);
        vertex2.addNeighbourVertex(vertex3);
        
        bfs.bfs(vertex1);
    }
    
}
