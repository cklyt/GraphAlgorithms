/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_star_algorithm;

/**
 *
 * @author lllyu
 */
public class Node {
    private int g;
    private int h;
    private int rowIndex;
    private int colIndex;
    private Node predecessor;
    private boolean isBlock;
    
    public Node(int rowIndex,int colIndex)
    {
        this.rowIndex=rowIndex;
        this.colIndex = colIndex;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }
    public int getF(){
        return this.g+this.h;
    }
    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public boolean isIsBlock() {
        return isBlock;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }
    @Override
    public boolean equals(Object node2){
        Node otherNode = (Node)node2;
        return (this.rowIndex ==otherNode.getRowIndex())&&(this.colIndex==otherNode.getColIndex());
    }
    @Override
    public String toString(){
        return "Node ("+this.rowIndex+ ";" + this.colIndex+ ") h:" +this.h+ " - g:"+this.g+ " - f=" + (this.h +this.g);
        
    }
}
