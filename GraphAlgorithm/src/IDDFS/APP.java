/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDDFS;

/**
 *
 * @author lllyu
 */
public class APP {
    
    public static void main(String[] args) {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");

        n1.addNeighbour(n2);
        n1.addNeighbour(n3);
        n2.addNeighbour(n4);
        n4.addNeighbour(n5);
        
        Algorithm algorithm = new Algorithm(n5);
        algorithm.runDeepenningSearch(n1);
    }

}
