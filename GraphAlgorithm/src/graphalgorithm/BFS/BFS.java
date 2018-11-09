/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author lllyu
 */
public class BFS {
    public void bfs(Vertex root)
    {
        Queue<Vertex> queue = new LinkedList<>();
        
        root.setVisited(true);
        queue.add(root);
        while(!queue.isEmpty())
        {
            Vertex actualVertex = queue.remove();
            System.out.print(actualVertex+"");
            for(Vertex v : actualVertex.getNeighbourList())
            {
                if(!v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
