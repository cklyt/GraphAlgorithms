/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_star_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author lllyu
 */
public class AStarAlgorithm {
    private Node[][] searchSpace;
    private Node startNode;
    private Node finalNode;
    private List<Node> closedSet;
    private Queue<Node> openSet;
    
    public AStarAlgorithm(){
        this.searchSpace = new Node[Constants.NUM_ROWS][Constants.NUM_COLS];
        this.openSet= new PriorityQueue<>(new NodeComparator());
        this.closedSet = new ArrayList<>();
        initializeSearchSpace();
    }

    private void initializeSearchSpace() {
        for(int rowIndex=0;rowIndex<Constants.NUM_ROWS;rowIndex++){
            for(int colIndex=0;colIndex< Constants.NUM_COLS;colIndex++)
            {
                Node node = new Node(rowIndex, colIndex);
                this.searchSpace[rowIndex][colIndex] = node;
            }
        }
        
        this.searchSpace[1][7].setIsBlock(true);
        this.searchSpace[2][3].setIsBlock(true);
        this.searchSpace[2][4].setIsBlock(true);
        this.searchSpace[2][4].setIsBlock(true);
        this.searchSpace[2][4].setIsBlock(true);
        this.searchSpace[2][5].setIsBlock(true);
        this.searchSpace[2][6].setIsBlock(true);
        this.searchSpace[2][7].setIsBlock(true);
        
        this.startNode = this.searchSpace[3][3];
        this.finalNode = this.searchSpace[1][6];
    }
    private List<Node> getAllNeighbors(Node node){
        List<Node> neighbors = new ArrayList<>();
        
        int row = node.getRowIndex();
        int col = node.getColIndex();
        
        if((row-1 >= 0 )&&(!this.searchSpace[row-1][col].isIsBlock())){
            searchSpace[row-1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
            searchSpace[row-1][col].setH(manhattanHeuristic(searchSpace[row-1][col],finalNode));
            neighbors.add(this.searchSpace[row-1][col]);
        }
        
        if((row+1 < Constants.NUM_ROWS )&&(!this.searchSpace[row+1][col].isIsBlock())){
            searchSpace[row+1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
            searchSpace[row+1][col].setH(manhattanHeuristic(searchSpace[row+1][col],finalNode));
            neighbors.add(this.searchSpace[row+1][col]);
        }
        
        if((col-1 >= 0 )&&(!this.searchSpace[row][col-1].isIsBlock())){
            searchSpace[row][col-1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
            searchSpace[row][col-1].setH(manhattanHeuristic(searchSpace[row][col-1],finalNode));
            neighbors.add(this.searchSpace[row][col-1]);
        }
        
        if((col+1 <Constants.NUM_COLS )&&(!this.searchSpace[row][col+1].isIsBlock())){
            searchSpace[row][col+1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
            searchSpace[row][col+1].setH(manhattanHeuristic(searchSpace[row][col+1],finalNode));
            neighbors.add(this.searchSpace[row][col+1]);
        }
        
        return neighbors;
    }
    public void search(){
        startNode.setH(manhattanHeuristic(startNode,finalNode));
        openSet.add(startNode);
        
        while(!openSet.isEmpty()){
            Node currentNode = openSet.poll();
            System.out.println(currentNode +" Predecessor is: "+currentNode.getPredecessor());
            
            if(currentNode.equals(finalNode)) return;
            
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            
            for(Node neighbor : getAllNeighbors(currentNode)){
                if(closedSet.contains(neighbor))continue;
                if(!openSet.contains(neighbor)) openSet.add(neighbor);
                
                neighbor.setPredecessor(currentNode);
                
            }
        }
    }
    
    public int manhattanHeuristic(Node node1,Node node2){
        return (Math.abs(node1.getRowIndex()-node2.getRowIndex())+Math.abs(node1.getColIndex()-node2.getColIndex()))*10;
    }
    public void showPath(){
        System.out.println("shortest path with a* search");
        
        Node node =this.finalNode;
        while(node!=null){
            System.out.println(node);
            node = node.getPredecessor();
        }
    }
}
