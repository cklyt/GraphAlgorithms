/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithm.DFS;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author lllyu
 */
public class DFS {
    private Stack<Vertex> stack;
    public DFS(){
        this.stack = new Stack<>();
    }
    public void dfs(List<Vertex> vertexList)
    {
        for(Vertex v : vertexList)
        {
            if(!v.isVisited())
            {
                v.setVisited(true);
                //dfsWithStack(v);
                dfsRecursive(v);
            }
        }
    }
    private void dfsRecursive(Vertex v){
        System.out.print(v+" ");
        
        for(Vertex vertex : v.getNeighbourList()){
            if(!vertex.isVisited())
            {
                vertex.setVisited(true);
                dfsRecursive(vertex);
            }
        }
    }
    private void dfsWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);
        
        while(!stack.isEmpty())
        {
            Vertex actualVertex = this.stack.pop();
            System.out.print(actualVertex+" ");
            
            for(Vertex v : actualVertex.getNeighbourList())
            {
                if(!v.isVisited())
                {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
